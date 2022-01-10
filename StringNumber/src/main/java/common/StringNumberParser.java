package common;


import com.interviewcake.evgenyk.Pair;
import eu.infomas.annotation.AnnotationDetector;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by Evgeny Kurtser on 06-Jan-22 at 8:30 PM.
 * <a href=mailto:lopotun@gmail.com>lopotun@gmail.com</a>
 * <img src="doc-files/StringToNumberRu.svg" alt="Foo">
 */
public abstract class StringNumberParser {
    /**
     * Parses the given input using the supplied FSM<p/>
     * <img src="../common/doc-files/StringToNumberRu.svg" alt="Foo">
     * @param input       number in text form e.g. "fourteen thousands two hundreds forty six"
     * @param fsmSupplier language-specific FSM
     * @return  numeric form of the given input, e.g. 14246
     * @throws UnrecognizedTokenException   if the given input cannot be transformed to numeric value
     */
    protected Long parseStringNumber(String input, Supplier<Map<Utils.NumberPosition, Map<String, Utils.StateWithNumber>>> fsmSupplier) throws UnrecognizedTokenException {
        long res = 0L, accum = 0L;
        Utils.StateWithNumber numberedState = Utils.INIT;

        final String[] strings = input.split("\\s+");   // Split the string: "sixty five" -> ["sixty", "five"]
        for (String s: strings) {
            // Get to next state based on the current string number
            numberedState = numberedState.state.nextState(s, fsmSupplier);
            if(numberedState == Utils.ERROR) {
                throw new UnrecognizedTokenException(String.format("Unrecognized token \"%s\"", s));
            }
            // This is the "millions", "thousands" delimiter.
            if(numberedState.state == ParsingState.S_Group) {
                accum *= numberedState.number; // Multiply accumulated value by 10^x
                res += accum;
                accum = 0L; // Reset accumulated value
            } else {
                accum += numberedState.number;
            }
        }
        res += accum;
        return res;
    }


    private static final Map<LanguageDetector.Language, Pair<Method, Object>> REFLECTIONS_CACHE = new HashMap<>();

    /**
     * Parses the given input using the supplied FSM<p/>
     * This implementation uses {@linkplain LanguageDetector#detectLanguage(String)} method in order to detect the input language.
     * Then it looks for class that contains method marked with {@link TextNumberParser} annotation
     * with correspond {@link TextNumberParser#languageCode()} parameter and invokes this method.
     * {@link StringNumberParser#parseStringNumber(String, Supplier)} method providing English parser FSM.
     * @param input       number in text form e.g. "fourteen thousands two hundreds forty six"
     * @return  numeric form of the given input, e.g. 14246
     * @throws LanguageException    if the input language couldn't be detected
     * @throws UnrecognizedTokenException   if the given input cannot be transformed to numeric value
     */
    public static Long parseNumbersString(String input) throws LanguageException, UnrecognizedTokenException {
        Long res = null;
        final Set<LanguageDetector.Language> lang = LanguageDetector.detectLanguage(input);
        if(lang.size() == 1) {
            final LanguageDetector.Language language = lang.stream().findFirst().get();
            final Pair<Method, Object> pair = REFLECTIONS_CACHE.computeIfAbsent(language, cla);
            if(pair != null) {
                try {
                    res = (Long)pair.getA().invoke(pair.getB(), input);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    if (e.getTargetException() instanceof RuntimeException) {
                        throw (RuntimeException)e.getTargetException();
                    }
                }
            }
        } else {
            throw new LanguageException("More than one language was detected.");
        }
        return res;
    }

    private static final Function<LanguageDetector.Language, Pair<Method, Object>> cla = language -> {
        try {
            @SuppressWarnings("unchecked")
            final Pair<Method, Object>[] res = new Pair[1];
            // Scan all .class files on the class path
            // Report all .class files, with TextNumberParser annotated methods
            final AnnotationDetector.MethodReporter methodReporter = new AnnotationDetector.MethodReporter() {
                @SuppressWarnings("unchecked")
                @Override
                public Class<? extends Annotation>[] annotations() {
                    return new Class[]{TextNumberParser.class};
                }

                @Override
                public void reportMethodAnnotation(Class<? extends Annotation> annotation, String className, String methodName) {
                    try {
                        Class<?> c = Class.forName(className);
                        final Method method = c.getMethod(methodName, String.class);
                        final TextNumberParser ann = method.getAnnotation(TextNumberParser.class);
                        if(language.getLangCode().equals(ann.languageCode())) {
                            final Object obj = c.getConstructor().newInstance();
                            res[0] = new Pair<>(method, obj);
                        }
                        System.out.println(annotation + "\t" + className + "\t" + methodName + "\t" + ann + "\t" + ann.languageCode());
                    } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            };
            new AnnotationDetector(methodReporter).detect();
            return res[0];
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    };
}
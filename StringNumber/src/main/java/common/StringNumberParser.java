package common;


import com.interviewcake.evgenyk.Pair;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

/**
 * Created by Evgeny Kurtser on 06-Jan-22 at 8:30 PM.
 * <a href=mailto:lopotun@gmail.com>lopotun@gmail.com</a>
 * <img src="doc-files/StringToNumberRu.svg" alt="Foo">
 */
public abstract class StringNumberParser {
    protected Long parseStringNumber(String input, Supplier<Map<Utils.NumberPosition, Map<String, Utils.StateWithNumber>>> f) {
        long res = 0L, accum = 0L;
        Utils.StateWithNumber numberedState = Utils.INIT;

        final String[] strings = input.split("\\s+");   // Split the string: "sixty five" -> ["sixty", "five"]
        for (String s: strings) {
            // Get to next state based on the current string number
            numberedState = numberedState.state.nextState(s, f);
            if(numberedState == Utils.ERROR) {
                throw new RuntimeException(String.format("Unrecognized token \"%s\"", s));
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
    public static Long parseNumbersString(String input) {
        Long res = null;
        final Set<LanguageDetector.Language> lang = LanguageDetector.detectLanguage(input);
        if(lang.size() == 1) {
            final LanguageDetector.Language language = lang.stream().findFirst().get();
            final Pair<Method, Object> pair = REFLECTIONS_CACHE.computeIfAbsent(language, lng -> {
                try {
                    Class c = Class.forName(lng.getLangCode() + ".LangNumberParser");
                    Method m = c.getMethod("parseStringNumber", String.class);
                    System.out.println(m.toString());
                    Object obj = c.getConstructor().newInstance();
                    return new Pair<>(m, obj);
                } catch (NoSuchMethodException | ClassNotFoundException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
                    e.printStackTrace();
                }
                return null;
            });
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
            throw new RuntimeException("More than one language was detected.");
        }
        return res;
    }
}
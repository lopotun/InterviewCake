package common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Evgeny Kurtser on 10-Jan-22 at 9:11 AM.
 * <a href=mailto:lopotun@gmail.com>lopotun@gmail.com</a>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TextNumberParser {
    /**
     * Supported language code e.g. "en" for English, "ru" for Russian, "he" for Hebrew etc.
     * @return  supported language
     */
    String languageCode();
}
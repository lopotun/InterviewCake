
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Evgeny Kurtser on 05-Jan-22 at 2:32 PM.
 * <a href=mailto:EvgenyK@traiana.com>EvgenyK@traiana.com</a>
 */
public class LanguageDetector {
    enum Language {
        ENGLISH('\u0041', '\u007A'),
        HEBREW('\u05D0', '\u05EA'),
        RUSSIAN('\u0410', '\u0451'),
        // Can be used to indicate multilingual input.
        MIXED('\u0000', '\u0000') {
            @Override
            boolean belongs(char c) {
                return false;
            }
        },
        // Can be used to indicate unrecognized language input.
        OTHER('\u0000', '\u0000') {
            @Override
            boolean belongs(char c) {
                return false;
            }
        };

        private final char from;
        private final char to;

        Language(char from, char to) {
            this.from = from;
            this.to = to;
        }

        int belongs(String text) {
            if (text == null || text.isEmpty()) {
                return -1;
            }
            return belongs(text.toCharArray(), 0);
        }

        int belongs(char[] text, int startFrom) {
            int res = -1;
            if (text == null || text.length == 0) {
                return res;
            }
            for (int i = startFrom; i < text.length; i++) {
                if (belongs(text[i])) {
                    res = i;
                } else {
                    break;
                }
            }
            return res;
        }

        boolean belongs(char c) {
            return (from <= c && c <= to) || !Character.isLetterOrDigit(c);
        }
    }


    public static Set<Language> detectLanguage(String text) {
        Set<Language> res = new HashSet<>();
        detectLanguage(text.toCharArray(), 0, res);
        return res;
    }

    private enum DetectStatus {CONTINUE, STOP}

    private static DetectStatus detectLanguage(char[] chars, int lrc, Set<Language> res) {
        DetectStatus detectStatus = DetectStatus.CONTINUE;
        for (Language lang : Language.values()) {
            int lastRecognizedCharacter = lang.belongs(chars, lrc);
            if (lastRecognizedCharacter > -1) { // The input string contains at least one character recognized by this language.
                res.add(lang);
                lrc = lastRecognizedCharacter + 1;
                if (chars.length == 0 || chars.length == lrc) {
                    detectStatus = DetectStatus.STOP;
                    break;
                }
                detectStatus = detectLanguage(chars, lrc, res);
                if (detectStatus == DetectStatus.STOP) {
                    break;
                }
            }
        }
        return detectStatus;
    }

    public static void main(String[] args) {
        final Set<Language> he = detectLanguage("אימא נקתה חלון");
        assert he.size() == 1 && he.contains(Language.HEBREW);

        final Set<Language> ru = detectLanguage("Мама мыла раму");
        assert ru.size() == 1 && ru.contains(Language.RUSSIAN);

        final Set<Language> en = detectLanguage("Mom cleaned a window");
        assert en.size() == 1 && en.contains(Language.ENGLISH);

        final Set<Language> mx = detectLanguage("Mom мыла חלון");
        assert mx.size() == 3;
    }
}

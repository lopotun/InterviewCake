package langparsers;

import common.*;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * This class contains method that converts the given input e.g. "fourteen thousands two hundreds forty six" to its numeric form -- 14246<p/>
 * Usually, one class contains one conversion method. However, you're free to put as many conversion method as you like in a single class
 * provided that each conversion method handles its own language (specified in {@link TextNumberParser#languageCode()} parameter).<p/>
 *
 * Created by Evgeny Kurtser on 09-Jan-22 at 2:28 PM.
 * <a href=mailto:lopotun@gmail.com>lopotun@gmail.com</a>
 */
public class LangNumberParserEn extends StringNumberParser {
    private static final String REGEX = "(?i)\s+(h)";

    /**
     * Converts the given input e.g. "fourteen thousands two hundreds forty six" to its numeric form -- 14246<p/>
     * This implementation uses {@link StringNumberParser#parseStringNumber(String, Supplier)} method providing English parser FSM.
     *
     * @param input number in text form e.g. "fourteen thousands two hundreds forty six"
     * @return numeric form of the given input
     * This method must be marked with {@link TextNumberParser} annotation. The {@link TextNumberParser#languageCode()} parameter indicates language (code) that is covered by this parser
     */
    @TextNumberParser(languageCode = "en")
    public Long parseStringNumber(String input) {
        input = input.replaceAll(REGEX, "_$1").replace("and ", "").toLowerCase();
        Supplier<Map<Utils.NumberPosition, Map<String, Utils.StateWithNumber>>> mapSupplier = () -> NUM_POS;
        return super.parseStringNumber(input, mapSupplier);
    }

    private static final Map<String, Utils.StateWithNumber> ONES_MAP = new HashMap<>();
    private static final Map<String, Utils.StateWithNumber> TENS_MAP = new HashMap<>();
    private static final Map<String, Utils.StateWithNumber> HUNDREDS_MAP = new HashMap<>();
    private static final Map<String, Utils.StateWithNumber> GROUPS_MAP = new HashMap<>();
    private static final Map<Utils.NumberPosition, Map<String, Utils.StateWithNumber>> NUM_POS = new HashMap<>();
    static {
        ONES_MAP.put("one", new Utils.StateWithNumber(ParsingState.S_1_9, 1L));
        ONES_MAP.put("two", new Utils.StateWithNumber(ParsingState.S_1_9, 2L));
        ONES_MAP.put("three", new Utils.StateWithNumber(ParsingState.S_1_9, 3L));
        ONES_MAP.put("four", new Utils.StateWithNumber(ParsingState.S_1_9, 4L));
        ONES_MAP.put("five", new Utils.StateWithNumber(ParsingState.S_1_9, 5L));
        ONES_MAP.put("six", new Utils.StateWithNumber(ParsingState.S_1_9, 6L));
        ONES_MAP.put("seven", new Utils.StateWithNumber(ParsingState.S_1_9, 7L));
        ONES_MAP.put("eight", new Utils.StateWithNumber(ParsingState.S_1_9, 8L));
        ONES_MAP.put("nine", new Utils.StateWithNumber(ParsingState.S_1_9, 9L));

        TENS_MAP.put("ten", new Utils.StateWithNumber(ParsingState.S_10_19, 10L));
        TENS_MAP.put("eleven", new Utils.StateWithNumber(ParsingState.S_10_19, 11L));
        TENS_MAP.put("twelve", new Utils.StateWithNumber(ParsingState.S_10_19, 12L));
        TENS_MAP.put("thirteen", new Utils.StateWithNumber(ParsingState.S_10_19, 13L));
        TENS_MAP.put("fourteen", new Utils.StateWithNumber(ParsingState.S_10_19, 14L));
        TENS_MAP.put("fifteen", new Utils.StateWithNumber(ParsingState.S_10_19, 15L));
        TENS_MAP.put("sixteen", new Utils.StateWithNumber(ParsingState.S_10_19, 16L));
        TENS_MAP.put("seventeen", new Utils.StateWithNumber(ParsingState.S_10_19, 17L));
        TENS_MAP.put("eighteen", new Utils.StateWithNumber(ParsingState.S_10_19, 18L));
        TENS_MAP.put("nineteen", new Utils.StateWithNumber(ParsingState.S_10_19, 19L));
        TENS_MAP.put("twenty", new Utils.StateWithNumber(ParsingState.S_20_90, 20L));
        TENS_MAP.put("thirty", new Utils.StateWithNumber(ParsingState.S_20_90, 30L));
        TENS_MAP.put("forty", new Utils.StateWithNumber(ParsingState.S_20_90, 40L));
        TENS_MAP.put("fifty", new Utils.StateWithNumber(ParsingState.S_20_90, 50L));
        TENS_MAP.put("sixty", new Utils.StateWithNumber(ParsingState.S_20_90, 60L));
        TENS_MAP.put("seventy", new Utils.StateWithNumber(ParsingState.S_20_90, 70L));
        TENS_MAP.put("eighty", new Utils.StateWithNumber(ParsingState.S_20_90, 80L));
        TENS_MAP.put("ninety", new Utils.StateWithNumber(ParsingState.S_20_90, 90L));

        HUNDREDS_MAP.put("hundred", new Utils.StateWithNumber(ParsingState.S_100_900, 100L));
        HUNDREDS_MAP.put("a_hundred", new Utils.StateWithNumber(ParsingState.S_100_900, 100L));
        HUNDREDS_MAP.put("one_hundred", new Utils.StateWithNumber(ParsingState.S_100_900, 100L));
        HUNDREDS_MAP.put("two_hundreds", new Utils.StateWithNumber(ParsingState.S_100_900, 200L));
        HUNDREDS_MAP.put("three_hundreds", new Utils.StateWithNumber(ParsingState.S_100_900, 300L));
        HUNDREDS_MAP.put("four_hundreds", new Utils.StateWithNumber(ParsingState.S_100_900, 400L));
        HUNDREDS_MAP.put("five_hundreds", new Utils.StateWithNumber(ParsingState.S_100_900, 500L));
        HUNDREDS_MAP.put("six_hundreds", new Utils.StateWithNumber(ParsingState.S_100_900, 600L));
        HUNDREDS_MAP.put("seven_hundreds", new Utils.StateWithNumber(ParsingState.S_100_900, 700L));
        HUNDREDS_MAP.put("eight_hundreds", new Utils.StateWithNumber(ParsingState.S_100_900, 800L));
        HUNDREDS_MAP.put("nine_hundreds", new Utils.StateWithNumber(ParsingState.S_100_900, 900L));

        GROUPS_MAP.put("thousand", new Utils.StateWithNumber(ParsingState.S_Group, 1_000L));
        GROUPS_MAP.put("thousands", new Utils.StateWithNumber(ParsingState.S_Group, 1_000L));
        GROUPS_MAP.put("million", new Utils.StateWithNumber(ParsingState.S_Group, 1_000_000L));
        GROUPS_MAP.put("millions", new Utils.StateWithNumber(ParsingState.S_Group, 1_000_000L));
        GROUPS_MAP.put("billion", new Utils.StateWithNumber(ParsingState.S_Group, 1_000_000_000L));
        GROUPS_MAP.put("billions", new Utils.StateWithNumber(ParsingState.S_Group, 1_000_000_000L));
        GROUPS_MAP.put("trillion", new Utils.StateWithNumber(ParsingState.S_Group, 1_000_000_000_000L));
        GROUPS_MAP.put("trillions", new Utils.StateWithNumber(ParsingState.S_Group, 1_000_000_000_000L));

        NUM_POS.put(Utils.NumberPosition.ONES, ONES_MAP);
        NUM_POS.put(Utils.NumberPosition.TENS, TENS_MAP);
        NUM_POS.put(Utils.NumberPosition.HUNDREDS, HUNDREDS_MAP);
        NUM_POS.put(Utils.NumberPosition.GROUPS, GROUPS_MAP);
    }
}
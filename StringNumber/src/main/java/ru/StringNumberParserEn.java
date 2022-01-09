package ru;

import common.ParsingState;
import common.StringNumberParser;
import common.Utils;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Created by Evgeny Kurtser on 06-Jan-22 at 8:30 PM.
 * <a href=mailto:lopotun@gmail.com>lopotun@gmail.com</a>
 * <img src="doc-files/StringToNumberRu.svg" alt="Foo">
 */
public class StringNumberParserEn extends StringNumberParser {
    private static final String REGEX = "(?i)\s+(h)";
    public Long parseStringNumber(String input) {
        input = input.replaceAll(REGEX, "_$1").replace("and ", "").toLowerCase();
        Supplier<Map<Utils.NumberPosition, Map<String, Utils.StateWithNumber>>> f = () -> NUM_POS;
        return super.parseStringNumber(input, f);
    }

    private static final Map<String, Utils.StateWithNumber> ONES = new HashMap<>();
    private static final Map<String, Utils.StateWithNumber> TENS = new HashMap<>();
    private static final Map<String, Utils.StateWithNumber> HUNDREDS = new HashMap<>();
    private static final Map<String, Utils.StateWithNumber> GROUPS = new HashMap<>();
    private static final Map<Utils.NumberPosition, Map<String, Utils.StateWithNumber>> NUM_POS = new HashMap<>();
    static {
        ONES.put("one", new Utils.StateWithNumber(ParsingState.S_1_9, 1L));
        ONES.put("two", new Utils.StateWithNumber(ParsingState.S_1_9, 2L));
        ONES.put("three", new Utils.StateWithNumber(ParsingState.S_1_9, 3L));
        ONES.put("four", new Utils.StateWithNumber(ParsingState.S_1_9, 4L));
        ONES.put("five", new Utils.StateWithNumber(ParsingState.S_1_9, 5L));
        ONES.put("six", new Utils.StateWithNumber(ParsingState.S_1_9, 6L));
        ONES.put("seven", new Utils.StateWithNumber(ParsingState.S_1_9, 7L));
        ONES.put("eight", new Utils.StateWithNumber(ParsingState.S_1_9, 8L));
        ONES.put("nine", new Utils.StateWithNumber(ParsingState.S_1_9, 9L));

        TENS.put("ten", new Utils.StateWithNumber(ParsingState.S_10_19, 10L));
        TENS.put("eleven", new Utils.StateWithNumber(ParsingState.S_10_19, 11L));
        TENS.put("twelve", new Utils.StateWithNumber(ParsingState.S_10_19, 12L));
        TENS.put("thirteen", new Utils.StateWithNumber(ParsingState.S_10_19, 13L));
        TENS.put("fourteen", new Utils.StateWithNumber(ParsingState.S_10_19, 14L));
        TENS.put("fifteen", new Utils.StateWithNumber(ParsingState.S_10_19, 15L));
        TENS.put("sixteen", new Utils.StateWithNumber(ParsingState.S_10_19, 16L));
        TENS.put("seventeen", new Utils.StateWithNumber(ParsingState.S_10_19, 17L));
        TENS.put("eighteen", new Utils.StateWithNumber(ParsingState.S_10_19, 18L));
        TENS.put("nineteen", new Utils.StateWithNumber(ParsingState.S_10_19, 19L));
        TENS.put("twenty", new Utils.StateWithNumber(ParsingState.S_20_90, 20L));
        TENS.put("thirty", new Utils.StateWithNumber(ParsingState.S_20_90, 30L));
        TENS.put("forty", new Utils.StateWithNumber(ParsingState.S_20_90, 40L));
        TENS.put("fifty", new Utils.StateWithNumber(ParsingState.S_20_90, 50L));
        TENS.put("sixty", new Utils.StateWithNumber(ParsingState.S_20_90, 60L));
        TENS.put("seventy", new Utils.StateWithNumber(ParsingState.S_20_90, 70L));
        TENS.put("eighty", new Utils.StateWithNumber(ParsingState.S_20_90, 80L));
        TENS.put("ninety", new Utils.StateWithNumber(ParsingState.S_20_90, 90L));

        HUNDREDS.put("hundred", new Utils.StateWithNumber(ParsingState.S_100_900, 100L));
        HUNDREDS.put("a_hundred", new Utils.StateWithNumber(ParsingState.S_100_900, 100L));
        HUNDREDS.put("one_hundred", new Utils.StateWithNumber(ParsingState.S_100_900, 100L));
        HUNDREDS.put("two_hundreds", new Utils.StateWithNumber(ParsingState.S_100_900, 200L));
        HUNDREDS.put("three_hundreds", new Utils.StateWithNumber(ParsingState.S_100_900, 300L));
        HUNDREDS.put("four_hundreds", new Utils.StateWithNumber(ParsingState.S_100_900, 400L));
        HUNDREDS.put("five_hundreds", new Utils.StateWithNumber(ParsingState.S_100_900, 500L));
        HUNDREDS.put("six_hundreds", new Utils.StateWithNumber(ParsingState.S_100_900, 600L));
        HUNDREDS.put("seven_hundreds", new Utils.StateWithNumber(ParsingState.S_100_900, 700L));
        HUNDREDS.put("eight_hundreds", new Utils.StateWithNumber(ParsingState.S_100_900, 800L));
        HUNDREDS.put("nine_hundreds", new Utils.StateWithNumber(ParsingState.S_100_900, 900L));

        GROUPS.put("thousand", new Utils.StateWithNumber(ParsingState.S_Group, 1_000L));
        GROUPS.put("thousands", new Utils.StateWithNumber(ParsingState.S_Group, 1_000L));
        GROUPS.put("million", new Utils.StateWithNumber(ParsingState.S_Group, 1_000_000L));
        GROUPS.put("millions", new Utils.StateWithNumber(ParsingState.S_Group, 1_000_000L));
        GROUPS.put("billion", new Utils.StateWithNumber(ParsingState.S_Group, 1_000_000_000L));
        GROUPS.put("billions", new Utils.StateWithNumber(ParsingState.S_Group, 1_000_000_000L));
        GROUPS.put("trillion", new Utils.StateWithNumber(ParsingState.S_Group, 1_000_000_000_000L));
        GROUPS.put("trillions", new Utils.StateWithNumber(ParsingState.S_Group, 1_000_000_000_000L));

        NUM_POS.put(Utils.NumberPosition.O, ONES);
        NUM_POS.put(Utils.NumberPosition.T, TENS);
        NUM_POS.put(Utils.NumberPosition.H, HUNDREDS);
        NUM_POS.put(Utils.NumberPosition.G, GROUPS);
    }
}
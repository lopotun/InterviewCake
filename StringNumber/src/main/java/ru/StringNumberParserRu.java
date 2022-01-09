package ru;

import common.ParsingState;
import common.StringNumberParser;
import common.Utils;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Created by Evgeny Kurtser on 09-Jan-22 at 2:28 PM.
 * <a href=mailto:EvgenyK@traiana.com>EvgenyK@traiana.com</a>
 */
public class StringNumberParserRu extends StringNumberParser {
    public Long parseStringNumber(String input) {
        Supplier<Map<Utils.NumberPosition, Map<String, Utils.StateWithNumber>>> f = () -> NUM_POS;
        return super.parseStringNumber(input, f);
    }

    private static final Map<String, Utils.StateWithNumber> ONES = new HashMap<>();
    private static final Map<String, Utils.StateWithNumber> TENS = new HashMap<>();
    private static final Map<String, Utils.StateWithNumber> HUNDREDS = new HashMap<>();
    private static final Map<String, Utils.StateWithNumber> GROUPS = new HashMap<>();
    private static final Map<Utils.NumberPosition, Map<String, Utils.StateWithNumber>> NUM_POS = new HashMap<>();
    static {
        ONES.put("один", new Utils.StateWithNumber(ParsingState.S_1_9, 1L));
        ONES.put("одна", new Utils.StateWithNumber(ParsingState.S_1_9, 1L));
        ONES.put("два", new Utils.StateWithNumber(ParsingState.S_1_9, 2L));
        ONES.put("две", new Utils.StateWithNumber(ParsingState.S_1_9, 2L));
        ONES.put("три", new Utils.StateWithNumber(ParsingState.S_1_9, 3L));
        ONES.put("четыре", new Utils.StateWithNumber(ParsingState.S_1_9, 4L));
        ONES.put("пять", new Utils.StateWithNumber(ParsingState.S_1_9, 5L));
        ONES.put("шесть", new Utils.StateWithNumber(ParsingState.S_1_9, 6L));
        ONES.put("семь", new Utils.StateWithNumber(ParsingState.S_1_9, 7L));
        ONES.put("восемь", new Utils.StateWithNumber(ParsingState.S_1_9, 8L));
        ONES.put("девять", new Utils.StateWithNumber(ParsingState.S_1_9, 9L));

        TENS.put("десять", new Utils.StateWithNumber(ParsingState.S_10_19, 10L));
        TENS.put("одинадцать", new Utils.StateWithNumber(ParsingState.S_10_19, 11L));
        TENS.put("двенадцать", new Utils.StateWithNumber(ParsingState.S_10_19, 12L));
        TENS.put("тринадцать", new Utils.StateWithNumber(ParsingState.S_10_19, 13L));
        TENS.put("четырнадцать", new Utils.StateWithNumber(ParsingState.S_10_19, 14L));
        TENS.put("пятнадцать", new Utils.StateWithNumber(ParsingState.S_10_19, 15L));
        TENS.put("шестнадцать", new Utils.StateWithNumber(ParsingState.S_10_19, 16L));
        TENS.put("семнадцать", new Utils.StateWithNumber(ParsingState.S_10_19, 17L));
        TENS.put("восемнадцать", new Utils.StateWithNumber(ParsingState.S_10_19, 18L));
        TENS.put("девятнадцать", new Utils.StateWithNumber(ParsingState.S_10_19, 19L));
        TENS.put("двадцать", new Utils.StateWithNumber(ParsingState.S_20_90, 20L));
        TENS.put("тридцать", new Utils.StateWithNumber(ParsingState.S_20_90, 30L));
        TENS.put("сорок", new Utils.StateWithNumber(ParsingState.S_20_90, 40L));
        TENS.put("пятьдесят", new Utils.StateWithNumber(ParsingState.S_20_90, 50L));
        TENS.put("шестьдесят", new Utils.StateWithNumber(ParsingState.S_20_90, 60L));
        TENS.put("семьдесят", new Utils.StateWithNumber(ParsingState.S_20_90, 70L));
        TENS.put("восемьдесят", new Utils.StateWithNumber(ParsingState.S_20_90, 80L));
        TENS.put("девяносто", new Utils.StateWithNumber(ParsingState.S_20_90, 90L));

        HUNDREDS.put("сто", new Utils.StateWithNumber(ParsingState.S_100_900, 100L));
        HUNDREDS.put("двести", new Utils.StateWithNumber(ParsingState.S_100_900, 200L));
        HUNDREDS.put("триста", new Utils.StateWithNumber(ParsingState.S_100_900, 300L));
        HUNDREDS.put("четыреста", new Utils.StateWithNumber(ParsingState.S_100_900, 400L));
        HUNDREDS.put("пятьсот", new Utils.StateWithNumber(ParsingState.S_100_900, 500L));
        HUNDREDS.put("шестьсот", new Utils.StateWithNumber(ParsingState.S_100_900, 600L));
        HUNDREDS.put("семьсот", new Utils.StateWithNumber(ParsingState.S_100_900, 700L));
        HUNDREDS.put("восемьсот", new Utils.StateWithNumber(ParsingState.S_100_900, 800L));
        HUNDREDS.put("девятсот", new Utils.StateWithNumber(ParsingState.S_100_900, 900L));

        GROUPS.put("тысяч", new Utils.StateWithNumber(ParsingState.S_Group, 1_000L));
        GROUPS.put("тысяча", new Utils.StateWithNumber(ParsingState.S_Group, 1_000L));
        GROUPS.put("миллион", new Utils.StateWithNumber(ParsingState.S_Group, 1_000_000L));
        GROUPS.put("миллиона", new Utils.StateWithNumber(ParsingState.S_Group, 1_000_000L));
        GROUPS.put("миллионов", new Utils.StateWithNumber(ParsingState.S_Group, 1_000_000L));
        GROUPS.put("миллиард", new Utils.StateWithNumber(ParsingState.S_Group, 1_000_000_000L));
        GROUPS.put("миллиарда", new Utils.StateWithNumber(ParsingState.S_Group, 1_000_000_000L));
        GROUPS.put("миллиардов", new Utils.StateWithNumber(ParsingState.S_Group, 1_000_000_000L));
        GROUPS.put("триллион", new Utils.StateWithNumber(ParsingState.S_Group, 1_000_000_000_000L));
        GROUPS.put("триллиона", new Utils.StateWithNumber(ParsingState.S_Group, 1_000_000_000_000L));
        GROUPS.put("триллионов", new Utils.StateWithNumber(ParsingState.S_Group, 1_000_000_000_000L));

        NUM_POS.put(Utils.NumberPosition.O, ONES);
        NUM_POS.put(Utils.NumberPosition.T, TENS);
        NUM_POS.put(Utils.NumberPosition.H, HUNDREDS);
        NUM_POS.put(Utils.NumberPosition.G, GROUPS);
    }
}

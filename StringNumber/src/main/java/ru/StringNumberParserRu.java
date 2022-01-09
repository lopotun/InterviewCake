package ru;

import common.ParsingState;
import common.StringNumberParser;
import common.Utils;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Created by Evgeny Kurtser on 09-Jan-22 at 2:28 PM.
 * <a href=mailto:lopotun@gmail.com>lopotun@gmail.com</a>
 * <img src="../common/doc-files/StringToNumberRu.svg" alt="Foo">
 */
public class StringNumberParserRu extends StringNumberParser {
    public Long parseStringNumber(String input) {
        Supplier<Map<Utils.NumberPosition, Map<String, Utils.StateWithNumber>>> mapSupplier = () -> NUM_POS;
        return super.parseStringNumber(input, mapSupplier);
    }

    private static final Map<String, Utils.StateWithNumber> ONES_MAP = new HashMap<>();
    private static final Map<String, Utils.StateWithNumber> TENS_MAP = new HashMap<>();
    private static final Map<String, Utils.StateWithNumber> HUNDREDS_MAP = new HashMap<>();
    private static final Map<String, Utils.StateWithNumber> GROUPS_MAP = new HashMap<>();
    private static final Map<Utils.NumberPosition, Map<String, Utils.StateWithNumber>> NUM_POS = new HashMap<>();
    static {
        ONES_MAP.put("один", new Utils.StateWithNumber(ParsingState.S_1_9, 1L));
        ONES_MAP.put("одна", new Utils.StateWithNumber(ParsingState.S_1_9, 1L));
        ONES_MAP.put("два", new Utils.StateWithNumber(ParsingState.S_1_9, 2L));
        ONES_MAP.put("две", new Utils.StateWithNumber(ParsingState.S_1_9, 2L));
        ONES_MAP.put("три", new Utils.StateWithNumber(ParsingState.S_1_9, 3L));
        ONES_MAP.put("четыре", new Utils.StateWithNumber(ParsingState.S_1_9, 4L));
        ONES_MAP.put("пять", new Utils.StateWithNumber(ParsingState.S_1_9, 5L));
        ONES_MAP.put("шесть", new Utils.StateWithNumber(ParsingState.S_1_9, 6L));
        ONES_MAP.put("семь", new Utils.StateWithNumber(ParsingState.S_1_9, 7L));
        ONES_MAP.put("восемь", new Utils.StateWithNumber(ParsingState.S_1_9, 8L));
        ONES_MAP.put("девять", new Utils.StateWithNumber(ParsingState.S_1_9, 9L));

        TENS_MAP.put("десять", new Utils.StateWithNumber(ParsingState.S_10_19, 10L));
        TENS_MAP.put("одинадцать", new Utils.StateWithNumber(ParsingState.S_10_19, 11L));
        TENS_MAP.put("двенадцать", new Utils.StateWithNumber(ParsingState.S_10_19, 12L));
        TENS_MAP.put("тринадцать", new Utils.StateWithNumber(ParsingState.S_10_19, 13L));
        TENS_MAP.put("четырнадцать", new Utils.StateWithNumber(ParsingState.S_10_19, 14L));
        TENS_MAP.put("пятнадцать", new Utils.StateWithNumber(ParsingState.S_10_19, 15L));
        TENS_MAP.put("шестнадцать", new Utils.StateWithNumber(ParsingState.S_10_19, 16L));
        TENS_MAP.put("семнадцать", new Utils.StateWithNumber(ParsingState.S_10_19, 17L));
        TENS_MAP.put("восемнадцать", new Utils.StateWithNumber(ParsingState.S_10_19, 18L));
        TENS_MAP.put("девятнадцать", new Utils.StateWithNumber(ParsingState.S_10_19, 19L));
        TENS_MAP.put("двадцать", new Utils.StateWithNumber(ParsingState.S_20_90, 20L));
        TENS_MAP.put("тридцать", new Utils.StateWithNumber(ParsingState.S_20_90, 30L));
        TENS_MAP.put("сорок", new Utils.StateWithNumber(ParsingState.S_20_90, 40L));
        TENS_MAP.put("пятьдесят", new Utils.StateWithNumber(ParsingState.S_20_90, 50L));
        TENS_MAP.put("шестьдесят", new Utils.StateWithNumber(ParsingState.S_20_90, 60L));
        TENS_MAP.put("семьдесят", new Utils.StateWithNumber(ParsingState.S_20_90, 70L));
        TENS_MAP.put("восемьдесят", new Utils.StateWithNumber(ParsingState.S_20_90, 80L));
        TENS_MAP.put("девяносто", new Utils.StateWithNumber(ParsingState.S_20_90, 90L));

        HUNDREDS_MAP.put("сто", new Utils.StateWithNumber(ParsingState.S_100_900, 100L));
        HUNDREDS_MAP.put("двести", new Utils.StateWithNumber(ParsingState.S_100_900, 200L));
        HUNDREDS_MAP.put("триста", new Utils.StateWithNumber(ParsingState.S_100_900, 300L));
        HUNDREDS_MAP.put("четыреста", new Utils.StateWithNumber(ParsingState.S_100_900, 400L));
        HUNDREDS_MAP.put("пятьсот", new Utils.StateWithNumber(ParsingState.S_100_900, 500L));
        HUNDREDS_MAP.put("шестьсот", new Utils.StateWithNumber(ParsingState.S_100_900, 600L));
        HUNDREDS_MAP.put("семьсот", new Utils.StateWithNumber(ParsingState.S_100_900, 700L));
        HUNDREDS_MAP.put("восемьсот", new Utils.StateWithNumber(ParsingState.S_100_900, 800L));
        HUNDREDS_MAP.put("девятсот", new Utils.StateWithNumber(ParsingState.S_100_900, 900L));

        GROUPS_MAP.put("тысяч", new Utils.StateWithNumber(ParsingState.S_Group, 1_000L));
        GROUPS_MAP.put("тысяча", new Utils.StateWithNumber(ParsingState.S_Group, 1_000L));
        GROUPS_MAP.put("миллион", new Utils.StateWithNumber(ParsingState.S_Group, 1_000_000L));
        GROUPS_MAP.put("миллиона", new Utils.StateWithNumber(ParsingState.S_Group, 1_000_000L));
        GROUPS_MAP.put("миллионов", new Utils.StateWithNumber(ParsingState.S_Group, 1_000_000L));
        GROUPS_MAP.put("миллиард", new Utils.StateWithNumber(ParsingState.S_Group, 1_000_000_000L));
        GROUPS_MAP.put("миллиарда", new Utils.StateWithNumber(ParsingState.S_Group, 1_000_000_000L));
        GROUPS_MAP.put("миллиардов", new Utils.StateWithNumber(ParsingState.S_Group, 1_000_000_000L));
        GROUPS_MAP.put("триллион", new Utils.StateWithNumber(ParsingState.S_Group, 1_000_000_000_000L));
        GROUPS_MAP.put("триллиона", new Utils.StateWithNumber(ParsingState.S_Group, 1_000_000_000_000L));
        GROUPS_MAP.put("триллионов", new Utils.StateWithNumber(ParsingState.S_Group, 1_000_000_000_000L));

        NUM_POS.put(Utils.NumberPosition.ONES, ONES_MAP);
        NUM_POS.put(Utils.NumberPosition.TENS, TENS_MAP);
        NUM_POS.put(Utils.NumberPosition.HUNDREDS, HUNDREDS_MAP);
        NUM_POS.put(Utils.NumberPosition.GROUPS, GROUPS_MAP);
    }
}

package ru;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Evgeny Kurtser on 08-Jan-22 at 10:47 PM.
 * <a href=mailto:lopotun@gmail.com>lopotun@gmail.com</a>
 */
public class UtilsRu {
    private static final Map<String, StateWithNumber> ONES = new HashMap<>();
    private static final Map<String, StateWithNumber> TENS = new HashMap<>();
    private static final Map<String, StateWithNumber> HUNDREDS = new HashMap<>();
    private static final Map<String, StateWithNumber> GROUPS = new HashMap<>();
    static {
        ONES.put("один", new StateWithNumber(ParsingState.S_1_9, 1L));
        ONES.put("одна", new StateWithNumber(ParsingState.S_1_9, 1L));
        ONES.put("два", new StateWithNumber(ParsingState.S_1_9, 2L));
        ONES.put("две", new StateWithNumber(ParsingState.S_1_9, 2L));
        ONES.put("три", new StateWithNumber(ParsingState.S_1_9, 3L));
        ONES.put("четыре", new StateWithNumber(ParsingState.S_1_9, 4L));
        ONES.put("пять", new StateWithNumber(ParsingState.S_1_9, 5L));
        ONES.put("шесть", new StateWithNumber(ParsingState.S_1_9, 6L));
        ONES.put("семь", new StateWithNumber(ParsingState.S_1_9, 7L));
        ONES.put("восемь", new StateWithNumber(ParsingState.S_1_9, 8L));
        ONES.put("девять", new StateWithNumber(ParsingState.S_1_9, 9L));

        TENS.put("десять", new StateWithNumber(ParsingState.S_10_19, 10L));
        TENS.put("одинадцать", new StateWithNumber(ParsingState.S_10_19, 11L));
        TENS.put("двенадцать", new StateWithNumber(ParsingState.S_10_19, 12L));
        TENS.put("тринадцать", new StateWithNumber(ParsingState.S_10_19, 13L));
        TENS.put("четырнадцать", new StateWithNumber(ParsingState.S_10_19, 14L));
        TENS.put("пятнадцать", new StateWithNumber(ParsingState.S_10_19, 15L));
        TENS.put("шестнадцать", new StateWithNumber(ParsingState.S_10_19, 16L));
        TENS.put("семнадцать", new StateWithNumber(ParsingState.S_10_19, 17L));
        TENS.put("восемнадцать", new StateWithNumber(ParsingState.S_10_19, 18L));
        TENS.put("девятнадцать", new StateWithNumber(ParsingState.S_10_19, 19L));
        TENS.put("двадцать", new StateWithNumber(ParsingState.S_20_90, 20L));
        TENS.put("тридцать", new StateWithNumber(ParsingState.S_20_90, 30L));
        TENS.put("сорок", new StateWithNumber(ParsingState.S_20_90, 40L));
        TENS.put("пятьдесят", new StateWithNumber(ParsingState.S_20_90, 50L));
        TENS.put("шестьдесят", new StateWithNumber(ParsingState.S_20_90, 60L));
        TENS.put("семьдесят", new StateWithNumber(ParsingState.S_20_90, 70L));
        TENS.put("восемьдесят", new StateWithNumber(ParsingState.S_20_90, 80L));
        TENS.put("девяносто", new StateWithNumber(ParsingState.S_20_90, 90L));

        HUNDREDS.put("сто", new StateWithNumber(ParsingState.S_100_900, 100L));
        HUNDREDS.put("двести", new StateWithNumber(ParsingState.S_100_900, 200L));
        HUNDREDS.put("триста", new StateWithNumber(ParsingState.S_100_900, 300L));
        HUNDREDS.put("четыреста", new StateWithNumber(ParsingState.S_100_900, 400L));
        HUNDREDS.put("пятьсот", new StateWithNumber(ParsingState.S_100_900, 500L));
        HUNDREDS.put("шестьсот", new StateWithNumber(ParsingState.S_100_900, 600L));
        HUNDREDS.put("семьсот", new StateWithNumber(ParsingState.S_100_900, 700L));
        HUNDREDS.put("восемьсот", new StateWithNumber(ParsingState.S_100_900, 800L));
        HUNDREDS.put("девятсот", new StateWithNumber(ParsingState.S_100_900, 900L));

        GROUPS.put("тысяч", new StateWithNumber(ParsingState.S_Group, 1_000L));
        GROUPS.put("тысяча", new StateWithNumber(ParsingState.S_Group, 1_000L));
        GROUPS.put("миллион", new StateWithNumber(ParsingState.S_Group, 1_000_000L));
        GROUPS.put("миллиона", new StateWithNumber(ParsingState.S_Group, 1_000_000L));
        GROUPS.put("миллионов", new StateWithNumber(ParsingState.S_Group, 1_000_000L));
        GROUPS.put("миллиард", new StateWithNumber(ParsingState.S_Group, 1_000_000_000L));
        GROUPS.put("миллиарда", new StateWithNumber(ParsingState.S_Group, 1_000_000_000L));
        GROUPS.put("миллиардов", new StateWithNumber(ParsingState.S_Group, 1_000_000_000L));
        GROUPS.put("триллион", new StateWithNumber(ParsingState.S_Group, 1_000_000_000_000L));
        GROUPS.put("триллиона", new StateWithNumber(ParsingState.S_Group, 1_000_000_000_000L));
        GROUPS.put("триллионов", new StateWithNumber(ParsingState.S_Group, 1_000_000_000_000L));
    }

    /**
     * FSM entry point.
     */
    static final StateWithNumber INIT = new StateWithNumber(ParsingState.S_Group, 0L);
    /**
     * Indicates FSM unrecognized event.
     */
    static final StateWithNumber ERROR = new StateWithNumber(ParsingState.S_Error, -1L);
    static class StateWithNumber {
        ParsingState state;
        Long number;
        StateWithNumber(ParsingState state, Long number) {
            this.state = state;
            this.number = number;
        }
        @Override
        public String toString() {
            return state + " (" + number + ")";
        }
    }

    static StateWithNumber getState(String s) {
        StateWithNumber stateWithNumber = ONES.get(s);
        if(stateWithNumber == null) {
            stateWithNumber = TENS.get(s);
            if(stateWithNumber == null) {
                stateWithNumber = HUNDREDS.get(s);
                if(stateWithNumber == null) {
                    stateWithNumber = GROUPS.get(s);
                    if(stateWithNumber == null) {
                        stateWithNumber = ERROR;
                    }
                }
            }
        }
        return stateWithNumber;
    }
}
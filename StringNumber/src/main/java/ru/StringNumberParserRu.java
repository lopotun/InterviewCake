package ru;

import common.StringNumberParser;

/**
 * Created by Evgeny Kurtser on 06-Jan-22 at 8:30 PM.
 * <a href=mailto:lopotun@gmail.com>lopotun@gmail.com</a>
 * <img src="doc-files/StringToNumberRu.svg" alt="Foo">
 */
public class StringNumberParserRu implements StringNumberParser {
    public Long parseStringNumber(String input) {
        long res = 0L, accum = 0L;
        UtilsRu.StateWithNumber numberedState = UtilsRu.INIT;

        final String[] strings = input.split("\\s+");   // Split the string: "sixty five" -> ["sixty", "five"]
        for (String s: strings) {
            // Get to next state based on the current string number
            numberedState = numberedState.state.nextState(s);
            if(numberedState == UtilsRu.ERROR) {
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
}
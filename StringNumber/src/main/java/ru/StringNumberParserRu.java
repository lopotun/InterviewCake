package ru;

import common.StringNumberParser;

/**
 * Created by Evgeny Kurtser on 06-Jan-22 at 8:30 PM.
 * <a href=mailto:EvgenyK@traiana.com>EvgenyK@traiana.com</a>
 * <img src="doc-files/StringToNumberRu.svg" alt="Foo">
 */
public class StringNumberParserRu implements StringNumberParser {
    public Long parseStringNumber(String input) {
        long res = 0;
        ParsingState ps = ParsingState.S_Init;
        final String[] strings = input.split("\\s+");
        for (String s: strings) {
            final UtilsRu.StateWithNumber nextState = ps.nextState(s);
            if(nextState == UtilsRu.ERROR_STATE) {
                throw new RuntimeException(String.format("Unrecognized token \"%s\"", s));
            }
            if(nextState.number > 999) {
                res *= nextState.number;
            } else {
                res += nextState.number;
            }
            ps = nextState.state;
        }
        return res;
    }
}
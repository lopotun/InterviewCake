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



enum ParsingState {
    S_Init {
        @Override
        boolean checkState(ParsingState ps) {
            return ps == S_100_900 || ps == S_20_90 || ps == S_10_19 || ps == S_1_9 || ps == S_End;
        }
    },
    S_100_900 {
        @Override
        boolean checkState(ParsingState ps) {
            return ps == S_20_90 || ps == S_10_19 || ps == S_1_9 || ps == S_Init || ps == S_End;
        }
    },
    S_20_90 {
        @Override
        boolean checkState(ParsingState ps) {
            return ps == S_1_9 || ps == S_Init || ps == S_End;
        }
    },
    S_10_19 {
        @Override
        boolean checkState(ParsingState ps) {
            return ps == S_Init || ps == S_End;
        }
    },
    S_1_9 {
        @Override
        boolean checkState(ParsingState ps) {
            return ps == S_Init || ps == S_End;
        }
    },
    S_End {
        @Override
        boolean checkState(ParsingState ps) {
            return ps == S_End;
        }
    },
    S_Error {
        @Override
        boolean checkState(ParsingState ps) {
            return ps == S_Error;
        }
    };

    abstract boolean checkState(ParsingState ps);
    public UtilsRu.StateWithNumber nextState(String s) {
        final UtilsRu.StateWithNumber stateWithNumber = UtilsRu.getState(s);
        return checkState(stateWithNumber.state)? stateWithNumber : UtilsRu.ERROR_STATE;
    }
}
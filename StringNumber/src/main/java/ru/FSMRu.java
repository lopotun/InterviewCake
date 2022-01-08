package ru;

/**
 * Created by Evgeny Kurtser on 09-Jan-22 at 12:35 AM.
 * <a href=mailto:EvgenyK@traiana.com>EvgenyK@traiana.com</a>
 */
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
        return checkState(stateWithNumber.state) ? stateWithNumber : UtilsRu.ERROR_STATE;
    }
}

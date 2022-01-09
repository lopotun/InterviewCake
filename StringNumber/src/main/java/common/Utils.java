package common;

import java.util.Map;
import java.util.function.Supplier;

/**
 * Created by Evgeny Kurtser on 08-Jan-22 at 10:47 PM.
 * <a href=mailto:lopotun@gmail.com>lopotun@gmail.com</a>
 */
public class Utils {

    public enum NumberPosition{ONES, TENS, HUNDREDS, GROUPS}

    /**
     * FSM entry point.
     */
    public static final StateWithNumber INIT = new StateWithNumber(ParsingState.S_Group, 0L);
    /**
     * Indicates FSM unrecognized event.
     */
    public static final StateWithNumber ERROR = new StateWithNumber(ParsingState.S_Error, -1L);
    public static class StateWithNumber {
        public ParsingState state;
        public Long number;
        public StateWithNumber(ParsingState state, Long number) {
            this.state = state;
            this.number = number;
        }
        @Override
        public String toString() {
            return state + " (" + number + ")";
        }
    }


    public static StateWithNumber getState(String s, Supplier<Map<NumberPosition, Map<String, StateWithNumber>>> f) {
        final Map<NumberPosition, Map<String, StateWithNumber>> map = f.get();
        StateWithNumber stateWithNumber = map.get(NumberPosition.ONES).get(s);
        if(stateWithNumber == null) {
            stateWithNumber = map.get(NumberPosition.TENS).get(s);
            if(stateWithNumber == null) {
                stateWithNumber = map.get(NumberPosition.HUNDREDS).get(s);
                if(stateWithNumber == null) {
                    stateWithNumber = map.get(NumberPosition.GROUPS).get(s);
                    if(stateWithNumber == null) {
                        stateWithNumber = ERROR;
                    }
                }
            }
        }
        return stateWithNumber;
    }
}
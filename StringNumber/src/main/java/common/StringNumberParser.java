package common;


import java.util.Map;
import java.util.function.Supplier;

/**
 * Created by Evgeny Kurtser on 06-Jan-22 at 8:30 PM.
 * <a href=mailto:lopotun@gmail.com>lopotun@gmail.com</a>
 * <img src="doc-files/StringToNumberRu.svg" alt="Foo">
 */
public class StringNumberParser {
    protected Long parseStringNumber(String input, Supplier<Map<Utils.NumberPosition, Map<String, Utils.StateWithNumber>>> f) {
        long res = 0L, accum = 0L;
        Utils.StateWithNumber numberedState = Utils.INIT;

        final String[] strings = input.split("\\s+");   // Split the string: "sixty five" -> ["sixty", "five"]
        for (String s: strings) {
            // Get to next state based on the current string number
            numberedState = numberedState.state.nextState(s, f);
            if(numberedState == Utils.ERROR) {
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
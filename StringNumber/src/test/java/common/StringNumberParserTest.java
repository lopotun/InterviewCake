package common;

import en.LangNumberParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by Evgeny Kurtser on 08-Jan-22 at 11:43 PM.
 * <a href=mailto:lopotun@gmail.com>lopotun@gmail.com</a>
 */
class StringNumberParserTest {

    @Test
    void parse1() {
        assertEquals(StringNumberParser.parseNumbersString("one"), 1);
        assertEquals(StringNumberParser.parseNumbersString("один"), 1);
    }

    @Test
    void parse10() {
        assertEquals(StringNumberParser.parseNumbersString("ten"), 10);
        assertEquals(StringNumberParser.parseNumbersString("десять"), 10);
    }

    @Test
    void parse15() {
        assertEquals(StringNumberParser.parseNumbersString("fifteen"), 15);
        assertEquals(StringNumberParser.parseNumbersString("пятнадцать"), 15);
    }

    @Test
    void parse40() {
        assertEquals(StringNumberParser.parseNumbersString("forty"), 40);
        assertEquals(StringNumberParser.parseNumbersString("сорок"), 40);
    }

    @Test
    void parse42() {
        assertEquals(StringNumberParser.parseNumbersString("forty two"), 42);
        assertEquals(StringNumberParser.parseNumbersString("сорок два"), 42);
    }

    @Test
    void parse100() {
        assertEquals(StringNumberParser.parseNumbersString("a Hundred"), 100);
        assertEquals(StringNumberParser.parseNumbersString("сто"), 100);
    }

    @Test
    void parse107() {
        assertEquals(StringNumberParser.parseNumbersString("a hundred and seven"), 107);
        assertEquals(StringNumberParser.parseNumbersString("one hundred and seven"), 107);
        assertEquals(StringNumberParser.parseNumbersString("сто семь"), 107);
    }

    @Test
    void parse118() {
        assertEquals(StringNumberParser.parseNumbersString("a hundred eighteen"), 118);
        assertEquals(StringNumberParser.parseNumbersString("сто восемнадцать"), 118);
    }

    @Test
    void parse5_000() {
        assertEquals(StringNumberParser.parseNumbersString("five thousands"), 5_000);
        assertEquals(StringNumberParser.parseNumbersString("пять тысяч"), 5_000);
    }

    @Test
    void parse5_274() {
        assertEquals(StringNumberParser.parseNumbersString("five thousands two hundreds seventy four"), 5_274);
        assertEquals(StringNumberParser.parseNumbersString("пять тысяч двести семьдесят четыре"), 5_274);
    }


    @Test
    void parse152_385_112_008() {
        assertEquals(152_385_112_008L, StringNumberParser.parseNumbersString("a hundred and fifty two billion three hundreds eighty five millions a hundred twelve thousands and eight"));
        assertEquals(152_385_112_008L, StringNumberParser.parseNumbersString("сто пятьдесят два миллиарда триста восемьдесят пять миллионов сто двенадцать тысяч восемь"));
    }

    @Test
    void parseStringNumberInvalidInput() {
        assertThrows(RuntimeException.class, () -> StringNumberParser.parseNumbersString("five thousands two hundreds zaza seventy four"));
        assertThrows(RuntimeException.class, () -> StringNumberParser.parseNumbersString("пять тысяч двести zaza семьдесят четыре"));
    }
}
package ru;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by Evgeny Kurtser on 08-Jan-22 at 11:43 PM.
 * <a href=mailto:lopotun@gmail.com>lopotun@gmail.com</a>
 */
class StringNumberParserRuTest {

    @Test
    void regex1() {
        String regex = "(?i)\s+(h|m|tho|tri)";
        String res;
        res = "a hundred fifty six".replaceAll(regex, "_$1");
        assertEquals("a_hundred fifty six", res);
        res = "three thousands a hundred fifty six".replaceAll(regex, "_$1");
        assertEquals("three_thousands a_hundred fifty six", res);
        res = "three thousands a hundred and fifty and six".replaceAll(regex, "_$1").replace("and ", "");
        assertEquals("three_thousands a_hundred fifty six", res);
    }

    @Test
    void parse1() {
        StringNumberParserRu parser = new StringNumberParserRu();
        assertEquals(parser.parseStringNumber("один"), 1);
    }

    @Test
    void parse10() {
        StringNumberParserRu parser = new StringNumberParserRu();
        assertEquals(parser.parseStringNumber("десять"), 10);
    }

    @Test
    void parse15() {
        StringNumberParserRu parser = new StringNumberParserRu();
        assertEquals(parser.parseStringNumber("пятнадцать"), 15);
    }

    @Test
    void parse40() {
        StringNumberParserRu parser = new StringNumberParserRu();
        assertEquals(parser.parseStringNumber("сорок"), 40);
    }

    @Test
    void parse42() {
        StringNumberParserRu parser = new StringNumberParserRu();
        assertEquals(parser.parseStringNumber("сорок два"), 42);
    }

    @Test
    void parse100() {
        StringNumberParserRu parser = new StringNumberParserRu();
        assertEquals(parser.parseStringNumber("сто"), 100);
    }

    @Test
    void parse107() {
        StringNumberParserRu parser = new StringNumberParserRu();
        assertEquals(parser.parseStringNumber("сто семь"), 107);
    }

    @Test
    void parse118() {
        StringNumberParserRu parser = new StringNumberParserRu();
        assertEquals(parser.parseStringNumber("сто восемнадцать"), 118);
    }

    @Test
    void parse5_000() {
        StringNumberParserRu parser = new StringNumberParserRu();
        assertEquals(parser.parseStringNumber("пять тысяч"), 5_000);
    }

    @Test
    void parse5_274() {
        StringNumberParserRu parser = new StringNumberParserRu();
        assertEquals(parser.parseStringNumber("пять тысяч двести семьдесят четыре"), 5_274);
    }


    @Test
    void parse152_385_112_008() {
        StringNumberParserRu parser = new StringNumberParserRu();
        assertEquals(152_385_112_008L, parser.parseStringNumber("сто пятьдесят два миллиарда триста восемьдесят пять миллионов сто двенадцать тысяч восемь"));
    }

    @Test
    void parseStringNumberInvalidInput() {
        StringNumberParserRu parser = new StringNumberParserRu();
        assertThrows(RuntimeException.class, () -> parser.parseStringNumber("пять тысяч двести zaza семьдесят четыре"));
    }
}
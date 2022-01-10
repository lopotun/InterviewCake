package langparsers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by Evgeny Kurtser on 08-Jan-22 at 11:43 PM.
 * <a href=mailto:lopotun@gmail.com>lopotun@gmail.com</a>
 */
class LangNumberParserRuTest {

    @Test
    void parse1() {
        LangNumberParserRu parser = new LangNumberParserRu();
        assertEquals(parser.parseStringNumber("один"), 1);
    }

    @Test
    void parse10() {
        LangNumberParserRu parser = new LangNumberParserRu();
        assertEquals(parser.parseStringNumber("десять"), 10);
    }

    @Test
    void parse15() {
        LangNumberParserRu parser = new LangNumberParserRu();
        assertEquals(parser.parseStringNumber("пятнадцать"), 15);
    }

    @Test
    void parse40() {
        LangNumberParserRu parser = new LangNumberParserRu();
        assertEquals(parser.parseStringNumber("сорок"), 40);
    }

    @Test
    void parse42() {
        LangNumberParserRu parser = new LangNumberParserRu();
        assertEquals(parser.parseStringNumber("сорок два"), 42);
    }

    @Test
    void parse100() {
        LangNumberParserRu parser = new LangNumberParserRu();
        assertEquals(parser.parseStringNumber("сто"), 100);
    }

    @Test
    void parse107() {
        LangNumberParserRu parser = new LangNumberParserRu();
        assertEquals(parser.parseStringNumber("сто семь"), 107);
    }

    @Test
    void parse118() {
        LangNumberParserRu parser = new LangNumberParserRu();
        assertEquals(parser.parseStringNumber("сто восемнадцать"), 118);
    }

    @Test
    void parse5_000() {
        LangNumberParserRu parser = new LangNumberParserRu();
        assertEquals(parser.parseStringNumber("пять тысяч"), 5_000);
    }

    @Test
    void parse5_274() {
        LangNumberParserRu parser = new LangNumberParserRu();
        assertEquals(parser.parseStringNumber("пять тысяч двести семьдесят четыре"), 5_274);
    }


    @Test
    void parse152_385_112_008() {
        LangNumberParserRu parser = new LangNumberParserRu();
        assertEquals(152_385_112_008L, parser.parseStringNumber("сто пятьдесят два миллиарда триста восемьдесят пять миллионов сто двенадцать тысяч восемь"));
    }

    @Test
    void parseStringNumberInvalidInput() {
        LangNumberParserRu parser = new LangNumberParserRu();
        assertThrows(RuntimeException.class, () -> parser.parseStringNumber("пять тысяч двести zaza семьдесят четыре"));
    }
}
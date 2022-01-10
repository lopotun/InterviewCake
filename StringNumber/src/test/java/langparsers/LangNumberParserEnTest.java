package langparsers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by Evgeny Kurtser on 08-Jan-22 at 11:43 PM.
 * <a href=mailto:lopotun@gmail.com>lopotun@gmail.com</a>
 */
class LangNumberParserEnTest {

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
    void testReflection() {
        Long res = common.StringNumberParser.parseNumbersString("twelve");
        System.out.println(res);
        res = common.StringNumberParser.parseNumbersString("ten");
        System.out.println(res);
        res = common.StringNumberParser.parseNumbersString("семнадцать");
        System.out.println(res);
    }

    @Test
    void parse1() {
        LangNumberParserEn parser = new LangNumberParserEn();
        assertEquals(parser.parseStringNumber("one"), 1);
    }

    @Test
    void parse10() {
        LangNumberParserEn parser = new LangNumberParserEn();
        assertEquals(parser.parseStringNumber("ten"), 10);
    }

    @Test
    void parse15() {
        LangNumberParserEn parser = new LangNumberParserEn();
        assertEquals(parser.parseStringNumber("fifteen"), 15);
    }

    @Test
    void parse40() {
        LangNumberParserEn parser = new LangNumberParserEn();
        assertEquals(parser.parseStringNumber("forty"), 40);
    }

    @Test
    void parse42() {
        LangNumberParserEn parser = new LangNumberParserEn();
        assertEquals(parser.parseStringNumber("forty two"), 42);
    }

    @Test
    void parse100() {
        LangNumberParserEn parser = new LangNumberParserEn();
        assertEquals(parser.parseStringNumber("a Hundred"), 100);
    }

    @Test
    void parse107() {
        LangNumberParserEn parser = new LangNumberParserEn();
        assertEquals(parser.parseStringNumber("a hundred and seven"), 107);
    }

    @Test
    void parse118() {
        LangNumberParserEn parser = new LangNumberParserEn();
        assertEquals(parser.parseStringNumber("a hundred eighteen"), 118);
    }

    @Test
    void parse5_000() {
        LangNumberParserEn parser = new LangNumberParserEn();
        assertEquals(parser.parseStringNumber("five thousands"), 5_000);
    }

    @Test
    void parse1_000() {
        LangNumberParserEn parser = new LangNumberParserEn();
        assertEquals(parser.parseStringNumber("one thousand"), 1_000);
        assertEquals(parser.parseStringNumber("a thousand"), 1_000);
    }

    @Test
    void parse5_274() {
        LangNumberParserEn parser = new LangNumberParserEn();
        assertEquals(parser.parseStringNumber("five thousands two hundreds seventy four"), 5_274);
        assertEquals(parser.parseStringNumber("five thousands two hundreds seventy-four"), 5_274);
    }


    @Test
    void parse152_385_112_008() {
        LangNumberParserEn parser = new LangNumberParserEn();
        assertEquals(152_385_112_008L, parser.parseStringNumber("a hundred and fifty two billion three hundreds eighty five millions a hundred twelve thousands and eight"));
    }

    @Test
    void parseStringNumberInvalidInput() {
        LangNumberParserEn parser = new LangNumberParserEn();
        assertThrows(RuntimeException.class, () -> parser.parseStringNumber("five thousands two hundreds zaza seventy four"));
    }
}
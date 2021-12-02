package com.interviewcake.evgenyk;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {
    // Head tests
    @Test
    void testHeadOne() {
        assertEquals(Utils.head(List.of(1)), 1);
    }
    @Test
    void testHeadSeveral() {
        assertEquals(Utils.head(List.of(1, 2)), 1);
    }
    @Test
    void testHeadEmpty() {
        assertThrows(IndexOutOfBoundsException.class, () -> Utils.head(Collections.emptyList()));
    }
    @Test
    void testHeadNull() {
        assertThrows(NullPointerException.class, () -> Utils.head(null));
    }


    // Tail tests
    @Test
    void testTailOne() {
        assertEquals(Utils.tail(List.of(1)), Collections.emptyList());
    }
    @Test
    void testTailSeveral() {
        assertEquals(Utils.tail(List.of(1, 2)), List.of(2));
    }
    @Test
    void testTailEmpty() {
        assertThrows(IndexOutOfBoundsException.class, () -> Utils.tail(Collections.emptyList()));
    }
    @Test
    void testTailNull() {
        assertThrows(NullPointerException.class, () -> Utils.tail(null));
    }
}
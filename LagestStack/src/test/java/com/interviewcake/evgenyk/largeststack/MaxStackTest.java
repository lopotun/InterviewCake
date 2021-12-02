package com.interviewcake.evgenyk.largeststack;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class MaxStackTest {
    @Test
    void testGetMaxUp() {
        MaxStack x = new MaxStack();
        x.push(1);
        x.push(2);
        x.push(3);
        assertEquals(x.getMax(), 3);
    }
    @Test
    void testGetMaxDown() {
        MaxStack x = new MaxStack();
        x.push(3);
        x.push(2);
        x.push(1);
        assertEquals(x.getMax(), 3);
    }
    @Test
    void testGetMaxSame() {
        MaxStack x = new MaxStack();
        x.push(3);
        x.push(3);
        x.push(3);
        assertEquals(x.getMax(), 3);
    }
    @Test
    void testGetMaxOne() {
        MaxStack x = new MaxStack();
        x.push(3);
        assertEquals(x.getMax(), 3);
    }
    @Test
    void testGetMaxEmpty() {
        MaxStack x = new MaxStack();
        assertThrows(NoSuchElementException.class, x::getMax);
    }
}
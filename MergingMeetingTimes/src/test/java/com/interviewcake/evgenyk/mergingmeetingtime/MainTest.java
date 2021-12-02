package com.interviewcake.evgenyk.mergingmeetingtime;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void mergeRanges() {
        assertEquals(Main.mergeRanges(List.of(new Meeting(0, 1), new Meeting(3, 5), new Meeting(4, 8), new Meeting(10, 12), new Meeting(9, 10))), List.of(new Meeting(0, 1), new Meeting(3, 8), new Meeting(9, 12)));
        assertEquals(Main.mergeRanges(List.of(new Meeting(0, 1))), List.of(new Meeting(0, 1)));
        assertEquals(Main.mergeRanges(List.of(new Meeting(0, 1), new Meeting(1, 2), new Meeting(3, 6), new Meeting(4, 6), new Meeting(1, 5), new Meeting(9, 10))), List.of(new Meeting(0, 6), new Meeting(9, 10)));
        assertEquals(Main.mergeRanges(List.of(new Meeting(0, 1), new Meeting(1, 2), new Meeting(3, 6), new Meeting(4, 6), new Meeting(1, 5))), List.of(new Meeting(0, 6)));
        assertEquals(Main.mergeRanges(List.of(new Meeting(1, 5), new Meeting(2, 3))), List.of(new Meeting(1, 5)));
        assertEquals(Main.mergeRanges(List.of(new Meeting(1, 10), new Meeting(2, 6), new Meeting(3, 5), new Meeting(7, 9))), List.of(new Meeting(1, 10)));
    }
}
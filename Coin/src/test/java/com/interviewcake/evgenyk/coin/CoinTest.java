package com.interviewcake.evgenyk.coin;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CoinTest {

    @Test
    void prs17() {
        Coin x = new Coin();
        List<LinkedList<Integer>> res = x.parse(17, List.of(15, 10, 5, 3, 2, 1));
        //noinspection RedundantTypeArguments (explicit type arguments speedup compilation and analysis time)
        assertEquals(res, List.<List<Integer>>of(List.of(15, 2), List.of(15, 1, 1), List.of(10, 5, 2), List.of(10, 5, 1, 1), List.of(10, 3, 3, 1), List.of(10, 3, 2, 2), List.of(10, 3, 2, 1, 1), List.of(10, 3, 1, 1, 1, 1), List.of(10, 2, 2, 2, 1), List.of(10, 2, 2, 1, 1, 1), List.of(10, 2, 1, 1, 1, 1, 1), List.of(10, 1, 1, 1, 1, 1, 1, 1), List.of(5, 5, 5, 2), List.of(5, 5, 5, 1, 1), List.of(5, 5, 3, 3, 1), List.of(5, 5, 3, 2, 2), List.of(5, 5, 3, 2, 1, 1), List.of(5, 5, 3, 1, 1, 1, 1), List.of(5, 5, 2, 2, 2, 1), List.of(5, 5, 2, 2, 1, 1, 1), List.of(5, 5, 2, 1, 1, 1, 1, 1), List.of(5, 5, 1, 1, 1, 1, 1, 1, 1), List.of(5, 3, 3, 3, 3), List.of(5, 3, 3, 3, 2, 1), List.of(5, 3, 3, 3, 1, 1, 1), List.of(5, 3, 3, 2, 2, 2), List.of(5, 3, 3, 2, 2, 1, 1), List.of(5, 3, 3, 2, 1, 1, 1, 1), List.of(5, 3, 3, 1, 1, 1, 1, 1, 1), List.of(5, 3, 2, 2, 2, 2, 1), List.of(5, 3, 2, 2, 2, 1, 1, 1), List.of(5, 3, 2, 2, 1, 1, 1, 1, 1), List.of(5, 3, 2, 1, 1, 1, 1, 1, 1, 1), List.of(5, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1), List.of(5, 2, 2, 2, 2, 2, 2), List.of(5, 2, 2, 2, 2, 2, 1, 1), List.of(5, 2, 2, 2, 2, 1, 1, 1, 1), List.of(5, 2, 2, 2, 1, 1, 1, 1, 1, 1), List.of(5, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1), List.of(5, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1), List.of(5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1), List.of(3, 3, 3, 3, 3, 2), List.of(3, 3, 3, 3, 3, 1, 1), List.of(3, 3, 3, 3, 2, 2, 1), List.of(3, 3, 3, 3, 2, 1, 1, 1), List.of(3, 3, 3, 3, 1, 1, 1, 1, 1), List.of(3, 3, 3, 2, 2, 2, 2), List.of(3, 3, 3, 2, 2, 2, 1, 1), List.of(3, 3, 3, 2, 2, 1, 1, 1, 1), List.of(3, 3, 3, 2, 1, 1, 1, 1, 1, 1), List.of(3, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1), List.of(3, 3, 2, 2, 2, 2, 2, 1), List.of(3, 3, 2, 2, 2, 2, 1, 1, 1), List.of(3, 3, 2, 2, 2, 1, 1, 1, 1, 1), List.of(3, 3, 2, 2, 1, 1, 1, 1, 1, 1, 1), List.of(3, 3, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1), List.of(3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1), List.of(3, 2, 2, 2, 2, 2, 2, 2), List.of(3, 2, 2, 2, 2, 2, 2, 1, 1), List.of(3, 2, 2, 2, 2, 2, 1, 1, 1, 1), List.of(3, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1), List.of(3, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1), List.of(3, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1), List.of(3, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1), List.of(3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1), List.of(2, 2, 2, 2, 2, 2, 2, 2, 1), List.of(2, 2, 2, 2, 2, 2, 2, 1, 1, 1), List.of(2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1), List.of(2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1), List.of(2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1), List.of(2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1), List.of(2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1), List.of(2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1), List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1)));
    }
    @Test
    void prs4() {
        Coin x = new Coin();
        List<LinkedList<Integer>> res = x.parse(4, List.of(15, 10, 5, 3, 2, 1));
        assertEquals(res, List.of(List.of(3,1), List.of(2,2), List.of(2,1,1), List.of(1,1,1,1)));
    }
    @Test
    void prs0() {
        Coin x = new Coin();
        List<LinkedList<Integer>> res = x.parse(0, List.of(15, 10, 5, 3, 2, 1));
        assertEquals(res, Collections.emptyList());
    }
    @Test
    void prsNone() {
        Coin x = new Coin();
        List<LinkedList<Integer>> res = x.parse(17, List.of(15, 10, 5));
        assertEquals(res, Collections.emptyList());
    }
}
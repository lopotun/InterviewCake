package com.interviewcake.evgenyk.coin;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CoinTest {

    @Test
    void prs17() {
        Coin x = new Coin();
        x.parse(17, List.of(15, 10, 5, 3, 2, 1));
        System.out.println(x.stack);
    }
    @Test
    void prs4() {
        Coin x = new Coin();
        x.parse(4, List.of(15, 10, 5, 3, 2, 1));
        System.out.println(x.stack);
    }
    @Test
    void prs0() {
        Coin x = new Coin();
        x.parse(0, List.of(15, 10, 5, 3, 2, 1));
        System.out.println(x.stack);
    }
    @Test
    void prsNone() {
        Coin x = new Coin();
        x.parse(17, List.of(15, 10, 5));
        System.out.println(x.stack);
    }
}
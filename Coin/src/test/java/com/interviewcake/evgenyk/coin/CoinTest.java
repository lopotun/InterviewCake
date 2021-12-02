package com.interviewcake.evgenyk.coin;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CoinTest {

    @Test
    void prs() {
        Coin x = new Coin();
        List<Integer> res = new ArrayList<>();
        x.prs(17, List.of(15, 10, 5, 3, 2, 1), res);
        System.out.println(res);
    }
}
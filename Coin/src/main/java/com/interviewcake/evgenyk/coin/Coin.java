package com.interviewcake.evgenyk.coin;

import com.interviewcake.evgenyk.Utils;

import java.util.List;

/**
 * https://www.interviewcake.com/question/java/coin
 */
public class Coin {
    /*
    17 (15, 10, 5, 3, 2, 1):
    15 + 2; 15 + 1 + 1
    10 + 5 + 2; 10 + 5 + 1 + 1
    5 + 5 + 5 + 2; 5 + 5 + 5 + 1 + 1;
    5 + 5 + 3 + 3 + 1; 5 + 5 + 3 + 2 + 2; 5 + 5 + 3 + 2 + 1 +1
     */
    //public List<List<Integer>> parse(int amount, List<Integer> denominations) {
    public void prs(int amount, List<Integer> denominations, List<Integer> res) {
        if(denominations.isEmpty()) {
            return;
        }
        int coin = Utils.head(denominations);
        int delta = amount - coin;
        if(delta < 0)
            prs(amount, Utils.tail(denominations), res);
        else {
            res.add(coin);
            if(delta > 0)
                prs(delta, denominations, res);
        }
    }
}

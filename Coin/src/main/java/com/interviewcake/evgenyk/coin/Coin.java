package com.interviewcake.evgenyk.coin;

import com.interviewcake.evgenyk.Utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * https://www.interviewcake.com/question/java/coin
 */
public class Coin {
    List<List<Integer>> stack = new ArrayList<>();
    /*
    17 (15, 10, 5, 3, 2, 1):
    15 + 2;     15 + 1 + 1
    10 + 5 + 2;     10 + 5 + 1 + 1;     10 + 3 + 3 +1;      10 + 3 + 2 + 2;     10 + 3 + 2 + 1 + 1;     10 + 3 + 1 + 1 + 1 + 1
    5 + 5 + 5 + 2;      5 + 5 + 5 + 1 + 1;      5 + 5 + 3 + 3 + 1;      5 + 5 + 3 + 2 + 2;       5 + 5 + 3 + 2 + 1 +1
     */
    public void parse(int amount, List<Integer> denominations) {
        LinkedList<Integer> res = new LinkedList<>();
        prs(amount, denominations, res);
    }
    public void prs(int amount, List<Integer> denominations, LinkedList<Integer> res) {
        if(denominations.isEmpty()) {
            if(!res.isEmpty())
                res.removeLast();
            return;
        }
        int coin = Utils.head(denominations);
        int delta = amount - coin;
        if(delta < 0) {
            prs(amount, Utils.tail(denominations), res);
        }
        else {
            res.addLast(coin);
            if(delta > 0)
                prs(delta, denominations, res);
            else {
                stack.add(new ArrayList<>(res));
                res.removeLast();
            }
            prs(amount, Utils.tail(denominations), res);
        }
    }
}

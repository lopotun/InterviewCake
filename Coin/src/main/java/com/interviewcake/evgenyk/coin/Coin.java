package com.interviewcake.evgenyk.coin;

import com.interviewcake.evgenyk.Utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://www.interviewcake.com/question/java/coin
 */
public class Coin {
    public List<LinkedList<Integer>> parse(int amount, List<Integer> denominations) {
        LinkedList<Integer> combination = new LinkedList<>();
        List<LinkedList<Integer>> res = new ArrayList<>();
        prs(amount, denominations, combination, res);
        return res;
    }

    private void prs(int amount, List<Integer> denominations, LinkedList<Integer> combination, List<LinkedList<Integer>> res) {
        if(denominations.isEmpty()) {
            if(!combination.isEmpty())
                combination.removeLast();
            return;
        }
        int coin = Utils.head(denominations);
        int delta = amount - coin;
        if(delta < 0)
            prs(amount, Utils.tail(denominations), combination, res);
        else {
            combination.addLast(coin);
            if(delta > 0)
                prs(delta, denominations, combination, res);
            else {
                res.add(new LinkedList<>(combination));
                combination.removeLast();
            }
            prs(amount, Utils.tail(denominations), combination, res);
        }
    }
}
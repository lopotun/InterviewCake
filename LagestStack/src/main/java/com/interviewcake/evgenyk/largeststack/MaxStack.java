package com.interviewcake.evgenyk.largeststack;

import java.util.*;

/**
 * https://www.interviewcake.com/question/java/largest-stack
 */
public class MaxStack extends Stack<Integer> {
    public Integer getMax() {
        return stream().max(Integer::compare).orElseThrow();
    }
}
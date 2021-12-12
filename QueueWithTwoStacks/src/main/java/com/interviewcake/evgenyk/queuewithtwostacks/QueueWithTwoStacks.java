package com.interviewcake.evgenyk.queuewithtwostacks;

import java.util.Stack;

/**
 * https://www.interviewcake.com/question/java/queue-two-stacks
 * Created by Evgeny Kurtser on 12-Dec-21 at 10:32 PM.
 * <a href=mailto:lopotun@gmail.com>lopotun@gmail.com</a>
 */
public class QueueWithTwoStacks<E> {
    private final Stack<E> in;
    private final Stack<E> out;

    public QueueWithTwoStacks() {
        in = new Stack<>();
        out = new Stack<>();
    }

    @SuppressWarnings("UnusedReturnValue")
    public E enqueue(E e) {
        return in.push(e);
    }

    public E dequeue() {
        if(out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }
}
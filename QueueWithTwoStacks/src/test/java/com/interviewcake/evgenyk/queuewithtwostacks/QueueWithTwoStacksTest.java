package com.interviewcake.evgenyk.queuewithtwostacks;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Evgeny Kurtser on 12-Dec-21 at 10:42 PM.
 * <a href=mailto:lopotun@gmail.com>lopotun@gmail.com</a>
 */
class QueueWithTwoStacksTest {

    @Test
    void zero() {
        QueueWithTwoStacks<Integer> x = new QueueWithTwoStacks<>();
        assertThrows(EmptyStackException.class, x::dequeue);
    }

    @Test
    void one() {
        QueueWithTwoStacks<Integer> x = new QueueWithTwoStacks<>();
        x.enqueue(42);
        assertEquals(x.dequeue(), 42);
    }

    @Test
    void two() {
        QueueWithTwoStacks<Integer> x = new QueueWithTwoStacks<>();
        x.enqueue(42);
        x.enqueue(75);
        assertEquals(x.dequeue(), 42);
        assertEquals(x.dequeue(), 75);
    }

    @Test
    void three() {
        QueueWithTwoStacks<Integer> x = new QueueWithTwoStacks<>();
        x.enqueue(42);
        x.enqueue(75);
        x.enqueue(15);
        assertEquals(x.dequeue(), 42);
        assertEquals(x.dequeue(), 75);
        assertEquals(x.dequeue(), 15);
        assertThrows(EmptyStackException.class, x::dequeue);
    }

    @Test
    void mix() {
        QueueWithTwoStacks<Integer> x = new QueueWithTwoStacks<>();
        x.enqueue(42);
        x.enqueue(75);
        assertEquals(x.dequeue(), 42);
        assertEquals(x.dequeue(), 75);

        x.enqueue(15);
        assertEquals(x.dequeue(), 15);

        x.enqueue(34);
        x.enqueue(25);
        assertEquals(x.dequeue(), 34);
        assertEquals(x.dequeue(), 25);

        assertThrows(EmptyStackException.class, x::dequeue);
    }
}
package com.interviewcake.evgenyk;

import lombok.*;

/**
 * Created by Evgeny Kurtser on 09-Dec-21 at 8:02 PM.
 * <a href=mailto:lopotun@gmail.com>lopotun@gmail.com</a>
 */
@Data
public class Pair<A, B> {
    private A a;
    private B b;

    public Pair(A a, B b) {
        this.a = a;
        this.b = b;
    }

    public Pair(Pair<A, B> other) {
        this.a = other.a;
        this.b = other.b;
    }

    public Pair<A, B> withA(A a) {
        return new Pair<>(a, this.b);
    }

    public Pair<A, B> withB(B b) {
        return new Pair<>(this.a, b);
    }

    public static <A, B> Pair<A, B> of(A a, B b) {
        return new Pair<>(a, b);
    }
}
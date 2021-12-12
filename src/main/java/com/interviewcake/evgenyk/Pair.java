package com.interviewcake.evgenyk;

import lombok.*;

/**
 * Created by Evgeny Kurtser on 09-Dec-21 at 8:02 PM.
 * <a href=mailto:lopotun@gmail.com>lopotun@gmail.com</a>
 */
@Data
@AllArgsConstructor
public class Pair<A, B> {
    @With private A a;
    @With private B b;

    public static <A, B> Pair<A, B> of(A a, B b) {
        return new Pair<>(a, b);
    }
}
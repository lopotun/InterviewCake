package com.interviewcake.evgenyk;

import lombok.*;

/**
 * Created by Evgeny Kurtser on 09-Dec-21 at 8:02 PM.
 * <a href=mailto:EvgenyK@traiana.com>EvgenyK@traiana.com</a>
 */
@Data
@RequiredArgsConstructor(staticName = "of")
public class Pair<A, B> {
    @NonNull private A a;
    @NonNull private B b;
}
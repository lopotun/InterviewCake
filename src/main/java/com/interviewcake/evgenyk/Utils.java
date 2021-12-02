package com.interviewcake.evgenyk;

import java.util.List;

import lombok.NonNull;

public final class Utils {
    public static <T> T head(@NonNull List<T> list) {
        return list.get(0);
    }

    public static <T> List<T> tail(@NonNull List<T> list) {
        return list.subList(1, list.size());
    }
}

package com.cts.personservice.util;

import java.util.UUID;

public final class GenerateIdUtils {

    private GenerateIdUtils() {
    }

    public static String getUUID() {
        return UUID.randomUUID()
                .toString()
                .replaceAll("-", "")
                .toUpperCase();
    }
}

package com.cts.personservice.util;

import java.util.Base64;
import java.util.Objects;

public final class EncodingUtils {

    private EncodingUtils() {
    }

    public static String encodeVersion(Long version) {
        Objects.requireNonNull(version, "version should not be null");
        String encoded = Base64.getEncoder().encodeToString(String.valueOf(version).getBytes());
        return encoded;
    }

    public static Long decodeVersion(String version) {
        Objects.requireNonNull(version, "version should not be null");
        String decoded = new String(Base64.getDecoder().decode(version));
        return Long.valueOf(decoded);
    }
}

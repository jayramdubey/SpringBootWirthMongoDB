package com.cts.personservice.util;

import org.apache.commons.lang3.EnumUtils;

import static java.util.Objects.isNull;

public final class EnumConvertUtils {

    public EnumConvertUtils() {
    }

    public static <E extends Enum<E>> E convertEnum(Class<E> enumType, Enum<?> enumValue) {
        E translatedEnum = null;
        if (!isNull(enumValue)) {
            translatedEnum = EnumUtils.getEnumIgnoreCase(enumType, enumValue.name());
        }
        return translatedEnum;
    }
}

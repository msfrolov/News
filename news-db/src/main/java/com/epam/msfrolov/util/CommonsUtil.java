package com.epam.msfrolov.util;


import com.epam.msfrolov.exception.AppException;
import com.epam.msfrolov.model.BaseEntity;

public final class CommonsUtil {

    private CommonsUtil() {
        // private constructor
    }

    // TODO !!!
    //    JAVAEE:
    //    @NotNull
    //    @Nullable
    //    Java Beans Validation (JSR-303 ??)

    public static void checkNotNull(Object o) {
        if (o == null) {
            throw new AppException("null validation fails");
        }
    }

    public static void checkExtendsBaseEntity(Object o) {
        if (!(o instanceof BaseEntity)) throw new AppException("failed validation: an instance of BaseEntity");
    }

    public static boolean isEntity(Object o) {
        return o instanceof BaseEntity;
    }

    public static String firstUpperCase(String s) {
        checkNotNull(s);
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

    public static String camelCaseToUpperCase(String s) {
        return s.replaceAll("([^_A-Z])([A-Z])", "$1_$2").toUpperCase();
    }

    public static String upperCaseToCamelCase(String s) {
        String[] parts = s.split("_");
        String result = "";
        for (String part : parts) {
            result = result
                    + part.substring(0, 1).toUpperCase()
                    + part.substring(1).toLowerCase();
        }
        return result.substring(0, 1).toLowerCase() + result.substring(1);
    }
}

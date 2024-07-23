package org.example;

public class ValidationUtils {

    public static int lengthShouldBe(int value, int min, int max) {
        if (value >= min && value <= max) {
            return value;
        } else {
            throw new RuntimeException("The value must be between " + min + " and " + max);
        }
    }

    public static <T> T requireNonNull(T obj) {
        if (obj == null) {
            throw new NullPointerException("The object cannot be null");
        }
        return obj;
    }
}

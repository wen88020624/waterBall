package main.java.org.example;

public class Utils {
    public static void printf(String format, Object... args) {
        System.out.printf(format, args);
    }

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

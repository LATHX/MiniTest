package indi.test.util;

public class Utils {
    public static boolean isEmpty(String text) {
        if (text == null || text.trim().length() == 0) {
            return true;
        }
        return false;
    }

    public static boolean isNotEmpty(String text) {
        return !isEmpty(text);
    }
}

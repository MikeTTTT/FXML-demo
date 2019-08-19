package utils;

/**
 * @author M.T.
 */
public class StringUtil {
    public StringUtil() {
    }

    public static boolean isEmpty(String var) {
        return var == null || var.length() == 0;
    }

    public static boolean isNotEmpty(String var) {
        return !isEmpty(var);
    }

    public static boolean equalsIgnoreCases(String var1, String var2) {
        return !isEmpty(var1) && !isEmpty(var2) ? var1.toUpperCase().equals(var2.toUpperCase()) : false;
    }
}
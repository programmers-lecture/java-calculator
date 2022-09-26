package caculator.utils;

public class Util {

    public static boolean isNumber(String number) {
        try {
            Double.parseDouble(number);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

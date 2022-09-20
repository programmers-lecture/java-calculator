package caculator.utils;

import caculator.enums.Operator;

public class Util {
    public static boolean isOperator(String operator) {
        return Operator.PLUS.isSameOperator(operator)
                || Operator.MINUS.isSameOperator(operator)
                || Operator.MULTIPLY.isSameOperator(operator)
                || Operator.DIVIDE.isSameOperator(operator);
    }

    public static boolean isNumber(String number) {
        try {
            Double.parseDouble(number);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

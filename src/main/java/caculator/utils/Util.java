package caculator.utils;

import caculator.enums.Operator;

public class Util {
    public static boolean isOperator(String operator) {
        return operator.equals(Operator.PLUS.getOperator())
                || operator.equals(Operator.MINUS.getOperator())
                || operator.equals(Operator.MULTIPLY.getOperator())
                || operator.equals(Operator.DIVIDE.getOperator());
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

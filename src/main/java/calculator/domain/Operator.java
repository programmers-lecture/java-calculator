package calculator.domain;

public class Operator {


    public String intCalculator(String startValue, String endValue, String operator) {
        if ("+".equals(operator)) {
            return plus(startValue, endValue);
        }
        if ("-".equals(operator)) {
            return minus(startValue, endValue);
        }
        if ("*".equals(operator)) {
            return multiply(startValue, endValue);
        }
        if ("/".equals(operator)) {
            return divide(startValue, endValue);
        }
        throw new IllegalArgumentException("올바르지 않은 연산자가 있습니다.");
    }

    private String plus(String startValue, String endValue) {
        return String.valueOf(Integer.valueOf(startValue) + Integer.valueOf(endValue));
    }

    private String minus(String startValue, String endValue) {
        return String.valueOf(Integer.valueOf(startValue) - Integer.valueOf(endValue));
    }

    public String multiply(String startValue, String endValue) {
        return String.valueOf(Integer.valueOf(startValue) * Integer.valueOf(endValue));
    }

    private String divide(String startValue, String endValue) {
        try{
            return String.valueOf(Integer.valueOf(startValue) / Integer.valueOf(endValue));
        } catch (Exception e){
            System.out.println("0으로 나눌 수 없습니다!");
        }
        return "";
    }

}

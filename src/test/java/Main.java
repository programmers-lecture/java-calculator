import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("1회용 문자열 계산기(제한:연산자1개 피연산자2개)");

        //입력
        final String expression = inputMethod();

        //추출
        int preOperand = getPreOperand(expression);
        int fixOperand = getFixOperand(expression);
        Operator operator = getOperator(expression);

        //연산
        final String answer = operateExpression(preOperand, fixOperand, operator);

        //출력
        outputMethod(answer);
    }

    public static void outputMethod(String answer) {
        if(answer.equals("")) System.out.println("연산결과가 없습니다.");
        else System.out.println(answer);
    }

    public static String operateExpression(int preOperand, int fixOperand, Operator operator) {

        switch (operator){
            case PLUS: return ""+(preOperand + fixOperand);
            case MINUS: return ""+(preOperand - fixOperand);
            case MULTIPLE: return ""+(preOperand * fixOperand);
            case DIVISOIN: return ""+(preOperand / fixOperand);
        }

        return "";
    }

    public static String inputMethod(){

        String str = "";

        Scanner sc = new Scanner(System.in);
        str = sc.nextLine().replaceAll(" ","");

        return str;
    }

    public static int getPreOperand(String str){
        return Character.getNumericValue(str.charAt(0));
    }
    public static int getFixOperand(String str){
        return Character.getNumericValue(str.charAt(2));
    }

    public static Operator getOperator(String str){
        String strOp = String.valueOf(str.charAt(1));
        Operator op=null;

        for(Operator operator : Operator.values()){
            if(strOp.equals(operator.getOperator())) return op = operator;
        }
        return op;
    }

}

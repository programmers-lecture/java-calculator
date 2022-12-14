import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("1회용 문자열 계산기(제한:연산자1개 피연산자2개)");

       final String expression = inputMethod();

       int preOperand =0;
       int fixOperand =0;
       Operator operator = null;

    }

    public static String inputMethod(){

        String str = "";

        Scanner sc = new Scanner(System.in);
        str = sc.nextLine().replaceAll(" ","");

        return str;
    }


}

import java.util.Scanner;

public class Main {

    public static String expression;
    public static void main(String[] args) {

        System.out.println("1회용 문자열 계산기(제한:연산자1개 피연산자2개)");

        expression = inputMethod();
        System.out.println(expression);

    }

    public static String inputMethod(){

        String str = "";

        Scanner sc = new Scanner(System.in);
        str = sc.nextLine().replaceAll(" ","");

        return str;
    }

}

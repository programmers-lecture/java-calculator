import java.util.Scanner;

public class StringCalculator {

    static Scanner sc;

    /*
    0. 문자열을 상수로 분리 - o
    1. main메서드 분리 - o
    2. enum으로 연산 처리 로직 구성하기
    3. 입력 (2.입력의 유효성 검사) 동시 처리 / 연산 / 결과를 출력 - 메서드로 분리
    4. 0번 클래스나 enum으로 분리해서 관리
    5. 3번 분리된 메서드 클래스화 하기
    */

    private static int calculateExpression(int totalValue, int fixOperand, char operator){
        int val = 0;

        return val;
    }

    static String insertExpression(){
        sc = new Scanner(System.in);
        final String str = sc.nextLine().replaceAll(" ","");
        return str;
    }

    static int getDiv(int result, char c) {
        return result / Character.getNumericValue(c);
    }

    static int getMul(int result, char c) {
        System.out.println(result + " " + Character.getNumericValue(c));
        return result * Character.getNumericValue(c);
    }

    static int getMinus(int result, char c) {
        return result - Character.getNumericValue(c);
    }

    static int getPlus(int result, char c) {
        return result + Character.getNumericValue(c);
    }
}

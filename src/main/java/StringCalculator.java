import java.util.Scanner;

public class StringCalculator {

    static Scanner sc;

    public static void main(String[] args) {

        /*
        1. 입력 (2.입력의 유효성 검사) 동시 처리
        3. 연산
        4. 결과를 출력
         */

        while(true) {

            System.out.println("StringCalculator (quit : 'end')");

            String str = insertExpression();
            if(str.equals("end")) break;

            char[] arr = str.toCharArray();

            int result = Character.getNumericValue(arr[0]);
            for(int i=1; i<arr.length-1; i+=2){                 // odd will be operator
                    switch(arr[i]){
                        case '+':
                            result = getPlus(result,arr[i+1]);
                            break;
                        case '-':
                            result = getMinus(result,arr[i+1]);
                            break;
                        case '*':
                            result = getMul(result,arr[i+1]);
                            break;
                        case '/':
                            result = getDiv(result,arr[i+1]);
                            break;
                    }
            }
            System.out.printf("결과 : %d\n\n", result);
        }
    }

    private static String insertExpression(){
        sc = new Scanner(System.in);
        return sc.nextLine().replaceAll(" ","");
    }

    private static int getDiv(int result, char c) {
        return result / Character.getNumericValue(c);
    }

    private static int getMul(int result, char c) {
        System.out.println(result + " " + Character.getNumericValue(c));
        return result * Character.getNumericValue(c);
    }

    private static int getMinus(int result, char c) {
        return result - Character.getNumericValue(c);
    }

    private static int getPlus(int result, char c) {
        return result + Character.getNumericValue(c);
    }
}

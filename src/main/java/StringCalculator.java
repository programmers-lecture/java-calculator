import java.util.Scanner;

public class StringCalculator {
    public static void main(String[] args) {


        while(true) {

            System.out.println("StringCalculator (quit : 'end')");

            Scanner sc = new Scanner(System.in);

            String str = sc.nextLine().replaceAll(" ","");
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

import java.util.Scanner;

public class StringCalculator {

	public static void main(String[] args) {

        int n = 5;
        while(n>0) {

            Scanner sc = new Scanner(System.in);

            String str = sc.nextLine().replaceAll(" ","");

            char[] arr = str.toCharArray();

            int result = Character.getNumericValue(arr[0]);
            for(int i=1; i<arr.length-1; i+=2){
                //if(Character.getNumericValue(arr[i])==-1){        // anyway odd will be operator
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
                //}
            }
            System.out.printf("°á°ú : %d\n\n", result);


            n--;
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

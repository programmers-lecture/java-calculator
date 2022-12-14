public class Main {
    // first intellij setup and commit

    public static void main(String[] args) {

        while(true) {

            System.out.println("StringCalculator (quit : 'end')");

            String str = StringCalculator.insertExpression();
            if(str.equals("end")) break;

            char[] arr = str.toCharArray();

            int result = Character.getNumericValue(arr[0]);
            for(int i=1; i<arr.length-1; i+=2){                 // odd will be operator
                switch(arr[i]){
                    case '+':
                        result = StringCalculator.getPlus(result,arr[i+1]);
                        break;
                    case '-':
                        result = StringCalculator.getMinus(result,arr[i+1]);
                        break;
                    case '*':
                        result = StringCalculator.getMul(result,arr[i+1]);
                        break;
                    case '/':
                        result = StringCalculator.getDiv(result,arr[i+1]);
                        break;
                }
            }
            System.out.printf("결과 : %d\n\n", result);
        }
    }

}

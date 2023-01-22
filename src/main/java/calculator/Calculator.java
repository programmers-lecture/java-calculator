package calculator;

public class Calculator {
    int result;
    private int firstNum;
    private int secondNum;
    String operation;


    Calculator(int firstNum, int secondNum, String operation){
        this.firstNum = firstNum;
        this.secondNum = secondNum;
        this.operation = operation;
    }

    public int calculate(){
        switch (operation){
            case "+" :
                result =add(firstNum, secondNum);
                break;
            case "-":
                result = subtract(firstNum, secondNum);
                break;
            case "*":
                result = multiply(firstNum, secondNum);
                break;
            case "/":
                result = divide(firstNum, secondNum);
                break;
        }
        return result;
    }

    public int add(int a, int b){
        return a+b;
    }

    public int subtract(int a, int b){
        return a-b;
    }

    public int multiply(int a, int b){
        return a*b;
    }

    public int divide(int a, int b){
        return a/b;
    }
}

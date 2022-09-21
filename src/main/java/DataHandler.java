import java.util.*;

public class DataHandler {
    private String inputString;
    private static HashMap<String, Integer> priorityMap = new HashMap<>();

    public DataHandler(String inputString) {
        this.inputString = inputString;
        priorityMap.put("+", 1);
        priorityMap.put("-", 1);
        priorityMap.put("*", 2);
        priorityMap.put("/", 2);
    }

    // TODO: getter setter 제거
    public String getInputString() {
        return inputString;
    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

    public int calculate() {
        String[] infix = inputString.split(" ");
        ArrayList<String> postfix = new ArrayList<>();
        Stack<String> operators = new Stack<>();
        Stack<String> stack = new Stack<>();

        for (String token : infix) { // TODO: depth 줄이기
            if (isNumeric(token)) {
                postfix.add(token);
            } else {
                // 연산자 우선순위
                while (!operators.isEmpty() && isPrior(operators.peek(), token)) {
                    postfix.add(operators.pop());
                }
                operators.push(token);
            }
        }

        // 연산자를 postfix에 추가
        while (!operators.isEmpty()) {
            postfix.add(operators.pop());
        }

        System.out.println(postfix);

        // postfix 계산
        for (String data : postfix) {
            if (isNumeric(data)) {
                stack.push(data);
            } else {
                int right = Integer.parseInt(stack.pop());
                int left = Integer.parseInt(stack.pop());
                int result = calcWithOperator(left, right, data);
                stack.push(String.valueOf(result));
            }

            System.out.println("stack = " + stack);
        }

        return Integer.parseInt(stack.pop());
    }

    private boolean isPrior(String operator1, String operator2) {
        // operator1 이 operator2 보다 연산순위가 같거나 높으면 true
        int priority1 = priorityMap.get(operator1);
        int priority2 = priorityMap.get(operator2);
        return priority1 >= priority2;
    }

    public boolean isNumeric(String data) {
        try {
            Integer.parseInt(data);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    public int calcWithOperator(int num1, int num2, String operator) {
        for (Operator o : Operator.values()) {
            if (o.getOPERATOR().equals(operator)) {
                return o.calculate(num1, num2);
            }
        }
        return 0;
    }

    public String findOperator(String operator) {
        for (Operator o : Operator.values()) {
            if (o.getOPERATOR().equals(operator)) {
                return o.getOPERATOR();
            }
        }
        return null;
    }
}

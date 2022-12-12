import java.util.Stack;

public class Postfix {
    public Postfix() {

    }
    public String converter(String[] arr) {
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for(String s : arr) {
            int p = priority(s);
            if(p == 0) {
                sb.append(s);
            } else {
                while(!stack.isEmpty() && priority(stack.peek()) >= p) {
                    sb.append(stack.pop());
                }
                stack.push(s);
            }
        }
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static int priority(String s) {
        switch (s) {
            case "*":
            case"/":
                return 2;
            case "+":
            case "-":
                return 1;
        }
        return 0;
    }
}

package calculator.domain;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class PostfixConvertor {
    private static Deque<String> stack = new ArrayDeque<>();
    private static int idx = 0;

    public String[] convertFormula(String[] elements){
        String[] convertArray = new String[elements.length];
        for(int i=0; i<elements.length; i++){
            comparePriority(convertArray, elements[i]);
        }
        addLeftStack(convertArray);
        return convertArray;
    }

    public boolean isOperator(String element){
        if (element.equals("+") || element.equals("-") || element.equals("*") || element.equals("/")){
            return true;
        }
        return false;
    }

    public void comparePriority(String[] convertArray, String element){
        if(!isOperator(element)){
            convertArray[idx++] = element;
            return;
        }
        while(!stack.isEmpty() && Operator.findOperator(stack.peek()).getPriority()>=Operator.findOperator(element).getPriority()){
            convertArray[idx++] = stack.pop();
        }
        stack.push(element);
        return;
    }

    public void addLeftStack(String[] convertArray){
        while(!stack.isEmpty()){
            convertArray[idx++] = stack.pop();
        }
    }


}

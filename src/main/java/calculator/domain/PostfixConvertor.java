package calculator.domain;

import java.util.ArrayDeque;
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


    public void comparePriority(String[] convertArray, String element){
        if(Character.isDigit(element.charAt(0))){
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

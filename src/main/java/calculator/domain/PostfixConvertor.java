package calculator.domain;

import java.util.ArrayDeque;
import java.util.Deque;

public class PostfixConvertor {
    private Deque<String> stack = new ArrayDeque<>();
    private int idx = 0;
    OperatorService operatorService = new OperatorService();

    public String[] convertFormula(String[] elements){
        String[] convertArray = new String[elements.length];
        for(int i=0; i<elements.length; i++){
          addElement(convertArray, elements[i]);
        }
        addLeftStack(convertArray);
        return convertArray;
    }

    public void addElement(String[] convertArray, String element){
        if(Character.isDigit(element.charAt(0))){
            convertArray[idx++] = element;
            return;
        }
        while(!stack.isEmpty() && comparePriority(element)){
            convertArray[idx++] = stack.pop();
        }
        stack.push(element);
    }
    public boolean comparePriority(String element){
        int peekPriority = operatorService.findPriority((stack.peek()));
        int elementPriority = operatorService.findPriority(element);
        return peekPriority>=elementPriority;
    }



    public void addLeftStack(String[] convertArray){
        while(!stack.isEmpty()){
            convertArray[idx++] = stack.pop();
        }
    }
}

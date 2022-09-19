package calculator.domain;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class PostfixConvertor {
    private static Deque<String> stack = new ArrayDeque<>();

    public String[] convertFormula(String[] elements){
        String[] convertArray = new String[elements.length];
        int idx = 0;
        for(int i=0; i<elements.length; i++){
            String element = elements[i];

        }

        while(!stack.isEmpty()){
            convertArray[idx] = stack.pop();
        }
        return convertArray;
    }

    public boolean isOperator(String element){
        if (element.equals("+") || element.equals("-") || element.equals("*") || element.equals("/")){
            return true;
        }
        return false;
    }

}

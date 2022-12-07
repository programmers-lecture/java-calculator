package calculator;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Result<T> {
    private T value;
    public void print(){
        System.out.println("결과 : "+value.toString());
    }
}

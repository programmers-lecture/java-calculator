package com.example.v1.specification;

import com.example.v1.processor.OperationProcessor;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * 후위 표기법으로 정의된 수식을 계산하는 클래스
 */
public final class Calculator implements CalculatorInterface {
	
	@Override
	public double calculate(String expression) {
		String[] tokens = expression.split(" ");
		Deque<Double> stack = new ConcurrentLinkedDeque<>();
		for (String token : tokens) {
			transaction(stack, token);
		}
		return stack.pop();
	}
	
	private void transaction(Deque<Double> stack, String token) {
		if (OperationProcessor.isOperator(token)) {
			double rightOperand = stack.pop();
			double leftOperand = stack.pop();
			double calculate = OperationProcessor.of(token).calculate(leftOperand, rightOperand);
			stack.push(calculate);
		} else {
			stack.push(Double.parseDouble(token));
		}
	}
}

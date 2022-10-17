package com.example.v1.specification;


import com.example.v1.processor.OperationProcessor;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

public final class CalculatorConverter extends CalculatorDecorator {
	
	private Calculator calculator;
	
	public CalculatorConverter(CalculatorInterface calculator) {
		super(calculator);
	}
	
	public double calculate(String infixExpression) {
		if (calculator == null) {
			this.calculator = new Calculator();
		}
		String postFix = parseExpressionInfixToPostFix(infixExpression);
		return calculator.calculate(postFix);
	}
	
	String parseExpressionInfixToPostFix(String inFixExpression) {
		StringBuilder postFixExpression = new StringBuilder();
		Deque<String> stack = new ConcurrentLinkedDeque<>();
		String[] tokens = inFixExpression.split(" ");
		for (String token : tokens) {
			makePostfixExpression(postFixExpression, stack, token);
		}
		while (!stack.isEmpty()) {
			postFixExpression.append(stack.pop());
			postFixExpression.append(" ");
		}
		return postFixExpression.toString().trim();
	}
	
	private void makePostfixExpression(StringBuilder stringBuilder, Deque<String> stack, String token) {
		if (OperationProcessor.isOperator(token)) {
			if (!stack.isEmpty() && OperationProcessor.priorityTo(stack.peek(), token)) {
				stringBuilder.append(stack.pop());
				stringBuilder.append(" ");
			}
			stack.push(token);
		} else {
			stringBuilder.append(token);
			stringBuilder.append(" ");
		}
	}
}

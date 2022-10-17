package com.example.v1.processor;

import com.example.v1.exception.NotSupportedOperationException;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum OperationProcessor {
	PLUS("+", 0, Double::sum),
	SUBTRACT("-", 0, (left, right) -> (left - right)),
	MULTIPLY("*", 1, (left, right) -> (left * right)),
	DIVIDE("/", 1, (left, right) -> {
		double result = left / right;
		if (Double.isInfinite(result)) {
			throw new ArithmeticException("0으로는 나눌 수 없습니다.");
		}
		return result;
	});
	
	private static final String OPERATOR_VALUE = "^[+\\-*/]$";
	private final String operator;
	private final int priority;
	private final BiFunction<Double, Double, Double> expression;
	
	private static final Map<String, OperationProcessor> OPERATOR_MAP = Arrays.stream(values())
		.collect(Collectors.toMap(OperationProcessor::getOperator, Function.identity()));
	
	OperationProcessor(String operator, int priority, BinaryOperator<Double> expression) {
		this.operator = operator;
		this.priority = priority;
		this.expression = expression;
	}

	/* == 정적 팩토리 메서드 패턴으로 제공하는 API == */
	// Map을 통해 구현한 방식 O(1)으로 접근
	public static OperationProcessor of(String operator) {
		return Optional.ofNullable(OPERATOR_MAP.get(operator))
			.orElseThrow(() -> new NotSupportedOperationException(operator));
	}
	
	// array stream을 통해 구현한 방식 O(n)으로 접근
	public static OperationProcessor arrayOf(String operator) {
		return Arrays.stream(values())
			.filter(v -> isEquals(operator, v))
			.findFirst()
			.orElseThrow(() -> new NotSupportedOperationException(operator));
	}
	
	// forEach를 통해 구현한 방식 O(n)으로 접근
	
	public static OperationProcessor forEachOf(String operator) {
		for (OperationProcessor op : values()) {
			if (isEquals(operator, op)) {
				return op;
			}
		}
		throw new NotSupportedOperationException(operator);
	}
	/* == 정적 팩토리 메서드 패턴으로 제공하는 API == */
	public static boolean isOperator(String userInput) {
		return Optional.ofNullable(userInput)
			.filter(s -> s.matches(OPERATOR_VALUE))
			.isPresent();
	}
	
	public static boolean priorityTo(String origin, String other) {
		return OperationProcessor.of(origin).priority >= OperationProcessor.of(other).priority;
	}
	
	public double calculate(double left, double right) {
		return expression.apply(left, right);
	}
	
	private static boolean isEquals(String operator, OperationProcessor v) {
		return v.operator.equals(operator);
	}
	
	private String getOperator() {
		return operator;
	}
}
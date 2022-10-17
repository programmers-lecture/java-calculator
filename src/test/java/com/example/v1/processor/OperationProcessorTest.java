package com.example.v1.processor;

import com.example.v1.exception.NotSupportedOperationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class OperationProcessorTest {
	
	private static Stream<Arguments> operatorDummy() {
		return Stream.of(
				Arguments.of("+", OperationProcessor.PLUS),
				Arguments.of("-", OperationProcessor.SUBTRACT),
				Arguments.of("*", OperationProcessor.MULTIPLY),
				Arguments.of("/", OperationProcessor.DIVIDE)
		);
	}
	
	private static Stream<Arguments> notOperatorDummy() {
		return Stream.of(
				Arguments.of("1"),
				Arguments.of("a"),
				Arguments.of("A")
		);
	}
	
	@DisplayName("연산자 프로세서 연산자 확인 테스트")
	@MethodSource("operatorDummy")
	@ParameterizedTest(name = "{index} => operator={0}, expected={1}")
	void testCase1(String operator, OperationProcessor expected) {
		// given
		
		// when
		OperationProcessor actual = OperationProcessor.of(operator);
		
		// then
		assertThat(actual).isEqualTo(expected);
	}
	
	@DisplayName("연산자 프로세서 연산자 확인 실패 테스트")
	@MethodSource("notOperatorDummy")
	@ParameterizedTest(name = "{index} => operator={0}")
	void testCase2(String notOperator) {
		assertThatExceptionOfType(NotSupportedOperationException.class)
				.isThrownBy(() -> OperationProcessor.of(notOperator));
	}
	
	@DisplayName("연산자 프로세서 연산자 확인 실패 테스트")
	@NullAndEmptySource
	@ParameterizedTest(name = "{index} => operator={0}")
	void testCase3(String notOperator) {
		assertThatExceptionOfType(NotSupportedOperationException.class)
				.isThrownBy(() -> OperationProcessor.of(notOperator));
	}
	
}
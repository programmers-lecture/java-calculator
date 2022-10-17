package com.example.v1.processor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class OperationProcessorThreadTest {
	
	@DisplayName("연산자 프로세서(Map) 멀티스레드 시간 측정 테스트")
	@ValueSource(ints = {1000})
	@ParameterizedTest(name = "{index} => threadCount={0}")
	void testCase1(int nThreads) {
		// given
		ExecutorService executorService = Executors.newFixedThreadPool(nThreads);
		CountDownLatch countDownLatch = new CountDownLatch(nThreads);
		
		// when
		long start = System.currentTimeMillis();
		for (int i = 0; i < nThreads; i++) {
			executorService.execute(() -> {
				OperationProcessor.of("+");
			});
			countDownLatch.countDown();
		}
		
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		
		// then
		System.out.println("Map time : " + (end - start));
	}
	
	@DisplayName("연산자 프로세서(arrays) 멀티스레드 시간 측정 테스트")
	@ValueSource(ints = {1000})
	@ParameterizedTest(name = "{index} => threadCount={0}")
	void testCase2(int nThreads) {
		// given
		ExecutorService executorService = Executors.newFixedThreadPool(nThreads);
		CountDownLatch countDownLatch = new CountDownLatch(nThreads);
		
		// when
		long start = System.currentTimeMillis();
		for (int i = 0; i < nThreads; i++) {
			executorService.execute(() -> {
				OperationProcessor.arrayOf("+");
			});
			countDownLatch.countDown();
		}
		
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		
		// then
		System.out.println("arrays time : " + (end - start));
	}
	
	@DisplayName("연산자 프로세서(forEach) 멀티스레드 시간 측정 테스트")
	@ValueSource(ints = {1000})
	@ParameterizedTest(name = "{index} => threadCount={0}")
	void testCase3(int nThreads) {
		// given
		ExecutorService executorService = Executors.newFixedThreadPool(nThreads);
		CountDownLatch countDownLatch = new CountDownLatch(nThreads);
		
		// when
		long start = System.currentTimeMillis();
		for (int i = 0; i < nThreads; i++) {
			executorService.execute(() -> {
				OperationProcessor.forEachOf("+");
			});
			countDownLatch.countDown();
		}
		
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		
		// then
		System.out.println("forEach time : " + (end - start));
	}
}
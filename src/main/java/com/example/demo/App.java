package com.example.demo;

import java.util.Timer;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
	@SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
	private CompletableFuture<Void> completableFuture;
	public static void main(String[] args) throws Exception {
		LOGGER.info("Welcome CompletableFuture Demo!");
		Stopwatch stopwatch = Stopwatch.createStarted();
		new App().proceed();	
		stopwatch.stop();	
		LOGGER.info("Time Elapsed : {}" , stopwatch.elapsed(TimeUnit.SECONDS));
	}

	public void proceed() {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		ExecutorService transformService = Executors.newFixedThreadPool(5);
		for (int i = 1; i <= 50; i++) {
			String registrationName = "name"+i;
			completableFuture = CompletableFuture.supplyAsync(() -> RegistrationUtil.createFakeRegistration(registrationName), executorService)
			.thenApplyAsync( RegistrationUtil::tranformRegistration,transformService)
			.thenAcceptAsync( RegistrationUtil::invokeCallbackUrl, transformService);
		}
		LOGGER.info("I am main Thread Contiuing my Usual Work and return to the caller!");
		completableFuture.join();
	}


	
}

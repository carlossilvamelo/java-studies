package com.javastudies.config;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class CustomRejectedExecutionHandler implements RejectedExecutionHandler {

	private final String poolName;

	public CustomRejectedExecutionHandler(String poolName) {
		this.poolName = poolName;
	}

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		final String errorMessage = String.format("Rejected task from '%s': %s", this.poolName, r);
		System.out.println(errorMessage);
		throw new RejectedExecutionException(errorMessage);
	}
}

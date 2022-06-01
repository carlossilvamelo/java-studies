package com.javastudies.config;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadConfig {

	private static final Integer CORE_POOL_SIZE = 1;
	private static final Integer MAXIMUM_POOL_SIZE = 4;
	private static final Integer KEEP_ALIVE_TIME = 3000;
	public static final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
			CORE_POOL_SIZE,
			MAXIMUM_POOL_SIZE,
			KEEP_ALIVE_TIME,
			TimeUnit.of(ChronoUnit.MILLIS),
			new LinkedBlockingQueue<>(),
			new CustomThreadFactory(),
			new CustomRejectedExecutionHandler("MY_THREAD")
	);



}

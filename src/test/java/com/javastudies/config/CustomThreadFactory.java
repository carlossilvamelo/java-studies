package com.javastudies.config;

import java.util.concurrent.ThreadFactory;

public class CustomThreadFactory implements ThreadFactory {
	@Override
	public Thread newThread(Runnable r) {
		return new Thread(r, "TEST_THEAD_RUNNABLE");
	}
}

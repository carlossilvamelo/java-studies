package com.javastudies.completablefuture;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.concurrent.CompletableFuture;

import org.junit.jupiter.api.Test;

import com.javastudies.mocks.CarListMock;

class CompletedAndFailedCF {

	@Test
	void completedFutures() {
		final var cars20 = CarListMock.getList(20);
		final var cars20CompletedAsync = new CompletableFuture().completeAsync(() -> cars20)
				.join();
		final var cars20Completed = CompletableFuture.completedFuture(cars20).join();

		assertEquals(cars20Completed, cars20CompletedAsync);
	}

	@Test
	void failedFutures() {

		assertThrows(RuntimeException.class, () -> CompletableFuture
				.failedFuture(new RuntimeException())
				.join());
		System.out.println("end");
	}
}

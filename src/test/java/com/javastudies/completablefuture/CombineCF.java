package com.javastudies.completablefuture;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;

import org.junit.jupiter.api.Test;

import com.javastudies.config.ThreadConfig;
import com.javastudies.domain.Car;
import com.javastudies.mocks.CarListMock;

class CombineCF {

	@Test
	void combine() {

		final var combinedList = getCompletableFuture(5)
				.thenCombine(
						getCompletableFuture(2),
						(list1, list2) -> {
							list1.addAll(list2);
							return list1;
						})
				.whenComplete((combined, throwable) -> {
					Optional.ofNullable(throwable)
							.ifPresent(error -> {
								throw new RuntimeException("fail when trying to merge list1 and list2", error);
							});
				}).thenCombine(
						getCompletableFuture(3),
						(list2, list3) -> {
							list2.addAll(list3);
							return list2;
						})
				.whenComplete((combined, throwable) -> {
					Optional.ofNullable(throwable)
							.ifPresent((error) -> {
								throw new RuntimeException("fail when trying to merge combinedList(1 and 2) and list3", error);
							});
				}).join();

		assertEquals(10, combinedList.size());

	}

	private CompletableFuture<List<Car>> getCompletableFuture(Integer sizeList) {
		return CompletableFuture.supplyAsync(() -> CarListMock.getList(sizeList), ThreadConfig.threadPoolExecutor);
	}
}

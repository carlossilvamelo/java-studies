package com.javastudies.completablefuture;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.javastudies.domain.Car;
import com.javastudies.mocks.CarListMock;

class AllOfCF {

	@Test
	void allOf() {
		/**
		 * Do Not combine the CFs
		 */
		final var completableFutureList = List.of(getCompletableFuture(5)
						, getCompletableFuture(2))
				.toArray(CompletableFuture[]::new);

		CompletableFuture.allOf(completableFutureList)
				.whenComplete((cf, throwable) -> {
					System.out.println("error");
				}).join();

		final var list = Arrays.stream(completableFutureList)
				.filter(CompletableFuture::isDone)
				.flatMap(cf -> {
					final var cars = (ArrayList<Car>) cf.join();
					return cars.stream();
				}).collect(Collectors.toList());
		assertEquals(7, list.size());
	}

	@Test
	void allOfJoined() {
		/**
		 * Do Not combine the CFs
		 */
		final var completableFutureList = List
				.of(getCompletableFuture(5), getCompletableFuture(2));

		final var combinedList = completableFutureList
				.stream()
				.map(CompletableFuture::join)
				.collect(Collectors.toList());

		assertEquals(7, combinedList.size());

	}

	private CompletableFuture<List<Car>> getCompletableFuture(Integer sizeList) {
		return CompletableFuture.supplyAsync(() -> {
			if (2 == sizeList) {
				System.out.println(2);
			}
			try {
				Thread.sleep(5000);
			}
			catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			return CarListMock.getList(sizeList);
		});
	}
}

package com.javastudies.optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.javastudies.domain.Person;
import com.javastudies.mocks.CarListMock;

public class OptionalValidations {

	@Test
	void present() {

		final var person = Person.builder()
				.cars(CarListMock.getList(2))
				.build();

		final var present = Optional.ofNullable(person)
				.map(Person::getCars)
				.isPresent();
		assertTrue(present);

	}

	@Test
	void notPresent() {

		final var person = Person.builder()
				.cars(null)
				.build();

		final var present = Optional
				.ofNullable(person)
				.map(Person::getCars)
				.isPresent();
		assertFalse(present);

		final var person2 = (Person) null;

		final var present2 = Optional
				.ofNullable(person)
				.map(Person::getCars)
				.isPresent();
		assertFalse(present);
	}
}

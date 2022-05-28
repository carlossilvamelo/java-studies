package com.javastudies.mocks;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.javastudies.domain.Car;
import com.javastudies.domain.enums.CarBrand;

public class CarListMock {

	private static final Random random = new Random();
	private static final Double MIN_DOUBLE = 0.0;
	private static final Double MAX_DOUBLE = 1000.0;
	private static final Long MIN_LONG = 0L;
	private static final Long MAX_LONG = 1000L;

	private static final List<CarBrand> BRANDS = List.of(CarBrand.FIAT, CarBrand.ALFA_ROMEO, CarBrand.VOLKSWAGEN);

	public static List<Car> getList(Integer listSize) {
		return IntStream.rangeClosed(1, listSize)
				.mapToObj(index -> getOneByBrand(getRandomBrand()))
				.collect(Collectors.toList());

	}

	private static Car getOneByBrand(CarBrand carBrand) {
		return Car.builder()
				.name(CarBrand.getRandomCarName(carBrand))
				.width(nextFloatInRange(MIN_DOUBLE.floatValue(), MAX_DOUBLE.floatValue()))
				.build();

	}

	private static CarBrand getRandomBrand() {
		return BRANDS.get(nextIntInRange(0, 2));
	}

	private static Integer nextIntInRange(Integer min, Integer max) {
		return random.ints(min, max)
				.findFirst()
				.getAsInt();
	}

	private static Float nextFloatInRange(Float min, Float max) {
		return Double.valueOf(random.doubles(min, max)
						.findFirst()
						.getAsDouble())
				.floatValue();
	}

	private static Double nextFloatInRange(Double min, Double max) {
		return random.doubles(min, max)
				.findFirst()
				.getAsDouble();
	}
}

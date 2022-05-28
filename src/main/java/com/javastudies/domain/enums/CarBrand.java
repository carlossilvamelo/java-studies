package com.javastudies.domain.enums;

import java.util.Random;

public enum CarBrand {
	FIAT("500", "Punto","Tipo","Strada","Mobi"),
	ALFA_ROMEO("Giulia","MiTo","Stelvio","4C","Giulietta"),
	VOLKSWAGEN("Voyage","Virtus","Golf","Tiguan","Taos");

	private String[] carNames;

	CarBrand(String... names) {
		carNames = names;
	}

	public static String getRandomCarName(CarBrand carBrand){
		return carBrand.carNames[nextIntInRange(0,4)];
	}

	private static Integer nextIntInRange(Integer min, Integer max) {
		return new Random().ints(min, max)
				.findFirst()
				.getAsInt();
	}
}

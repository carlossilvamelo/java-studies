package com.javastudies.domain;

import com.javastudies.domain.enums.CarBrand;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Car {

	private final String name;
	private final CarBrand carBrand;
	private final Float width;

}

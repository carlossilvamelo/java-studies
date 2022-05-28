package com.javastudies.domain;

import java.util.List;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Person {

	private final List<Car> cars;
}

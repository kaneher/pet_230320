package com.pet.dog.domain;

import java.time.ZonedDateTime;

import lombok.Data;
import lombok.ToString;

@ToString
@Data  // getter, setter
public class Dog {

	private int id;
	private int userId;
	private String dogName;
	private int dogAge;
	private int dogKindId;
	private int dogWeight;
	private String dogProfileImagePath;
	private ZonedDateTime createdAt;
	private ZonedDateTime updatedAt;
}

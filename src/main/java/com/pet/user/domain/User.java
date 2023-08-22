package com.pet.user.domain;

import java.time.ZonedDateTime;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class User {

	private int id;
	private String loginId;
	private String password;
	private String name;
	private String email;
	private String profileImagePath;
	private ZonedDateTime createdAt;
	private ZonedDateTime updatedAt;
}

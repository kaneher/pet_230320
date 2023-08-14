package com.pet.post.domain;

import java.time.ZonedDateTime;

import lombok.Data;
import lombok.ToString;

@ToString
@Data  // getter, setter
public class Post {
	private int id;
	private int userId;
	private String subject;
	private String content;
	private String postImagePath;
	private ZonedDateTime createdAt;
	private ZonedDateTime updatedAt;
}
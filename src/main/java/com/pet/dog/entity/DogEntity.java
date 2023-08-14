package com.pet.dog.entity;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "userdog")
@Getter
@Entity
public class DogEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "userId")
	private int userId;
	
	@Column(name = "dogName")
	private String dogName;
	
	@Column(name = "dogAge")
	private int dogAge;
	
	@Column(name = "dogKindId")
	private int dogKindId;
	
	@Column(name = "dogWeight")
	private int dogWeight;
	
	@Column(name = "dogProfileImagePath")
	private MultipartFile dogProfileImagePath;
	
	@UpdateTimestamp
	@Column(name = "createdAt", updatable = false)
	private ZonedDateTime createdAt;
	
	@UpdateTimestamp
	@Column(name = "updatedAt")
	private ZonedDateTime updatedAt;
}

package com.pet.dog.dao;

import org.apache.ibatis.annotations.Param;

import com.pet.dog.domain.Dog;

public interface DogMapper {

	public Dog selectDogByDogIdAndUserId(
			@Param("dogId") int dogId,
			@Param("userId") int userId);
	
	public int updateDogByDogIdAndUserId(
			@Param("dogId") int dogId,
			@Param("userId") int userId,
			@Param("dogAge") int dogAge,
			@Param("dogWeight") int dogWeight,
			@Param("dogProfileImagePath") String dogProfileImagePath);
}

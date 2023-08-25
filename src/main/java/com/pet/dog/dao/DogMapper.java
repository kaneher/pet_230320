package com.pet.dog.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.pet.dog.domain.Dog;

@Repository
public interface DogMapper {

	public Dog selectDogByDogIdAndUserId(
			@Param("dogId") int dogId,
			@Param("userId") int userId);
	
	public void updateDogByDogIdAndUserId(
			@Param("dogId") int dogId,
			@Param("userId") int userId,
			@Param("dogAge") int dogAge,
			@Param("dogWeight") int dogWeight,
			@Param("dogProfileImagePath") String dogProfileImagePath);
	
	public void deleteDogByDogIdAndUserId(
			@Param("dogId") int dogId, 
			@Param("userId") int userId);
}

package com.pet.user.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
	
	public void updateUserInformation(
			@Param("userId") int userId,
			@Param("userLoginId") String userLoginId,
			@Param("hashedPassword") String hashedPassword,
			@Param("email") String email,
			@Param("imagePath") String imagePath);
}

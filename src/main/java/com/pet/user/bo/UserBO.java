package com.pet.user.bo;

import org.springframework.beans.factory.annotation.Autowired;

import com.pet.user.dao.UserRepository;
import com.pet.user.entity.UserEntity;

public class UserBO {

	@Autowired
	private UserRepository userRepository;

	// input: loginId
	// output: UserEntity(null or 채워져 있거나)
	public UserEntity getUserEntityByLoginId(String loginId) {
		return userRepository.findByLoginId(loginId);
	}
}

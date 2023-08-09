package com.pet.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pet.user.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	
	public UserEntity findByLoginId(String loginId);

}

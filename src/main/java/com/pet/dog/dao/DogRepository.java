package com.pet.dog.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pet.dog.entity.DogEntity;

public interface DogRepository extends JpaRepository<DogEntity, Integer> {

	
}

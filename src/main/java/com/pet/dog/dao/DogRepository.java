package com.pet.dog.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pet.dog.entity.DogEntity;

@Repository
public interface DogRepository extends JpaRepository<DogEntity, Integer> {

	public List<DogEntity> findByUserId(int userId);
}

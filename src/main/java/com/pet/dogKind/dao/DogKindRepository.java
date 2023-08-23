package com.pet.dogKind.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pet.dogKind.entity.DogKindEntity;

@Repository
public interface DogKindRepository extends JpaRepository<DogKindEntity, Integer> {

	public DogKindEntity findByDogKind(String dogKind);
	
	public List<DogKindEntity> findAll();
}

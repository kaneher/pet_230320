package com.pet.dogKind.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pet.dogKind.dao.DogKindRepository;
import com.pet.dogKind.entity.DogKindEntity;

@Service
public class DogKindBO {
	
	@Autowired
	private DogKindRepository dogKindRepository;
		
	public DogKindEntity getDogKind(String dogKind) {
		return dogKindRepository.findByDogKind(dogKind);
	}

}

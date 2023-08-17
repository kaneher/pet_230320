package com.pet.dogKind.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.pet.dogKind.dao.DogKindRepository;
import com.pet.dogKind.entity.DogKindEntity;

@Service
public class DogKindBO {
	
	@Autowired
	private DogKindRepository dogKindRepository;
		
	public DogKindEntity getDogKind(
			@RequestParam("dogKind") String dogKind) {
		return dogKindRepository.findByDogKind(dogKind);
	}

}

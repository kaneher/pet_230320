package com.pet.dog.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pet.dog.dao.DogRepository;

@Service
public class DogBO {
	
	@Autowired
	private DogRepository dogRepository;
	
	

}

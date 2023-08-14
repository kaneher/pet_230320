package com.pet.dog.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pet.dog.dao.DogRepository;
import com.pet.dog.entity.DogEntity;

@Service
public class DogBO {
	
	@Autowired
	private DogRepository dogRepository;
	
	// input : dog 관련 requestParameter
	// output : DogEntity => id pk 추출
	public Integer addDog(int userId, String dogName, int dogAge, int dogKindId, int dogWeight, MultipartFile file) {
		// save
		DogEntity dogEntity = dogRepository.save(
								DogEntity.builder()
								.userId(userId)
								.dogName(dogName)
								.dogAge(dogAge)
								.dogKindId(dogKindId)
								.dogWeight(dogWeight)
								.dogProfileImagePath(file)
								.build()
							);
		return dogEntity == null ? null : dogEntity.getId(); // pk만 리턴
	}

}

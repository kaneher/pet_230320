package com.pet.dog.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pet.common.FileManagerService;
import com.pet.dog.dao.DogRepository;
import com.pet.dog.entity.DogEntity;

@Service
public class DogBO {
	
	@Autowired
	private DogRepository dogRepository;
	
	@Autowired
	private FileManagerService fileManager;
	
	// input : dog 관련 requestParameter
	// output : DogEntity => id pk 추출
	public Integer addDog(int userId, String dogName, int dogAge, int dogKindId, int dogWeight, MultipartFile file) {
		
		// 강아지 사진 이미지 처리
		String imagePath = null;
		if (file != null) {
			imagePath = fileManager.saveFile(dogName, file);
		}
		
		// 사용자가 입력한 견종과 dogKind 테이블에 있는 견종명 일치 여부 확인 후 dogKind 테이블 id(pk) 가져온 뒤 userDog 테이블 dogKindId에 저장
		
		
		// save
		DogEntity dogEntity = dogRepository.save(
								DogEntity.builder()
								.userId(userId)
								.dogName(dogName)
								.dogAge(dogAge)
								.dogKindId(dogKindId)
								.dogWeight(dogWeight)
								.dogProfileImagePath(imagePath)
								.build()
							);
		
		return dogEntity == null ? null : dogEntity.getId(); // pk만 리턴
	}

}

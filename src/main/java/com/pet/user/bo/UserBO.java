package com.pet.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pet.common.FileManagerService;
import com.pet.user.dao.UserMapper;
import com.pet.user.dao.UserRepository;
import com.pet.user.entity.UserEntity;

@Service
public class UserBO {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private FileManagerService fileManager;

	// input: loginId
	// output: UserEntity(null or 채워져 있거나)
	public UserEntity getUserEntityByLoginId(String loginId) {
		return userRepository.findByLoginId(loginId);
	}

	// input: user 관련 파라미터들
	// output: UserEntity => id pk 추출
	public Integer addUser(String loginId, String password, String name, String email, String address, String phoneNumber, MultipartFile file) {
		String imagePath = null;
		if (file != null) {
			imagePath = fileManager.saveFile(loginId, file);
		}
		
		// save
		UserEntity userEntity = userRepository.save(
								UserEntity.builder()
								.loginId(loginId)
								.password(password)
								.name(name)
								.email(email)
								.address(address)
								.phoneNumber(phoneNumber)
								.profileImagePath(imagePath)
								.build()
							);
		return userEntity == null ? null : userEntity.getId(); // pk만 리턴
	}
	
	// input: loginId, password
	// output: UserEntity
	public UserEntity getUserEntityByLoginIdPassword(String loginId, String password) {
		return userRepository.findByLoginIdAndPassword(loginId, password);
	}
	
	// input : userId
	// output : UserEntity
	public UserEntity getUserEntityByUserId(int userId) {
		
		return userRepository.findById(userId);
	}
	
	// input : RequestParameter
	// output : X
	public void updateUserInformation(int userId, String userLoginId, String hashedPassword, String email, String address, String phoneNumber, MultipartFile file) {
		
		// imagePath 처리
		String imagePath = null;
		if (file != null) {
			imagePath = fileManager.saveFile(userLoginId, file);
		}
		
		userMapper.updateUserInformation(userId, userLoginId, hashedPassword, email, address, phoneNumber, imagePath);
	}
}

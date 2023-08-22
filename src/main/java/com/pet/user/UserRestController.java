package com.pet.user;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pet.common.SHA256;
import com.pet.user.bo.UserBO;
import com.pet.user.entity.UserEntity;

@RestController
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	private UserBO userBO;

	/**
	 * 중복확인 API
	 * 
	 * @param loginId
	 * @return
	 */
	@RequestMapping("/is_duplicated_id")
	public Map<String, Object> isDuplicatedId(
			@RequestParam("loginId") String loginId) {

		Map<String, Object> result = new HashMap<>();
		result.put("isDuplicatedId", false);

		// select
		UserEntity userEntity = userBO.getUserEntityByLoginId(loginId);
		result.put("code", 1);

		if (userEntity != null) {
			result.put("isDuplicatedId", true);
		}

		return result;
	}

	/**
	 * 회원가입 API
	 * @param loginId
	 * @param password
	 * @param name
	 * @param email
	 * @param file
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	@PostMapping("/sign_up")
	public Map<String, Object> signUp(@RequestParam("loginId") String loginId,
			@RequestParam("password") String password, @RequestParam("name") String name,
			@RequestParam("email") String email, @RequestParam("profileImagePath") MultipartFile file) throws NoSuchAlgorithmException {

		// 비밀번호 해싱 - SHA 256
		SHA256 sha256 = new SHA256();
		String hashedPassword = sha256.encrypt(password);

		// DB insert
		Integer userId = userBO.addUser(loginId, hashedPassword, name, email, file);

		Map<String, Object> result = new HashMap<>();
		if (userId != null) {
			result.put("code", 1);
			result.put("result", "성공");
		} else {
			result.put("code", 500);
			result.put("errorMessage", "회원가입 하는데 실패했습니다.");
		}
		return result;
	}
	
	/**
	 * 로그인 API
	 * @param loginId
	 * @param password
	 * @param request
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	@PostMapping("/sign_in")
	public Map<String, Object> signIn(
			@RequestParam("loginId") String loginId,
			@RequestParam("password") String password,
			HttpServletRequest request) throws NoSuchAlgorithmException {
		
		// password hashing
		SHA256 sha256 = new SHA256();
		String hashedPassword = sha256.encrypt(password);
		
		// loginId, hashedPassword로 UserEntity => null or 채워져있음
		UserEntity userEntity = userBO.getUserEntityByLoginIdPassword(loginId, hashedPassword);
		
		Map<String, Object> result = new HashMap<>();
		if (userEntity != null) {
			// 로그인 처리
			HttpSession session = request.getSession();
			session.setAttribute("userId", userEntity.getId());
			session.setAttribute("userLoginId", userEntity.getLoginId());
			session.setAttribute("userName", userEntity.getName());
			result.put("code", 1);
			result.put("result", "성공");
		} else {
			// 로그인 불가
			result.put("code", 500);
			result.put("errorMessage", "존재하지 않는 사용자입니다.");
		}
		
		return result;
	}
	
	/**
	 * 내 정보 수정 API
	 * @param password
	 * @param email
	 * @param file
	 * @param session
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	@PostMapping("/update_user_information")
	public Map<String, Object> updateUserInformation(
			@RequestParam("password") String password,
			@RequestParam("email") String email,
			@RequestParam("file") MultipartFile file,
			HttpSession session) throws NoSuchAlgorithmException {
		
		// userId, userLoginId 받아오기
		int userId = (int)session.getAttribute("userId");
		String userLoginId = (String)session.getAttribute("userLoginId");
		
		// password hashing
		SHA256 sha256 = new SHA256();
		String hashedPassword = sha256.encrypt(password);
		
		// DB update
		userBO.updateUserInformation(userId, userLoginId, hashedPassword, email, file);
		
		Map<String, Object> result = new HashMap<>();
		result.put("code", 1);
		result.put("result", "성공");
		return result;
		}
	}


package com.pet.dog;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pet.dog.bo.DogBO;

@RestController
@RequestMapping("/dog")
public class DogRestController {
	
	@Autowired
	private DogBO dogBO;
	
	/**
	 * 반려견 정보 추가 API
	 * @param session
	 * @param dogName
	 * @param dogAge
	 * @param dogKind
	 * @param dogWeight
	 * @param file
	 * @return
	 */
	@PostMapping("/add_dog")
	public Map<String, Object> addDog(
			HttpSession session,
			@RequestParam("dogName") String dogName,
			@RequestParam("dogAge") int dogAge,
			@RequestParam("dogKind") String dogKind,
			@RequestParam("dogWeight") int dogWeight,
			@RequestParam(value = "file", required = false) MultipartFile file
			) {
		
		// 세션에서 userId 받아오기
		int userId = (int)session.getAttribute("userId");
		String userLoginId = (String)session.getAttribute("userLoginId");
		
		// DB insert
		Integer dogId = dogBO.addDog(userId, userLoginId, dogName, dogAge, dogKind, dogWeight, file);
		
		// 응답
		Map<String, Object> result = new HashMap<>();
		if (dogId != null) {
			result.put("code", 1);
			result.put("result", "성공");
		} else {
			result.put("code", 500);
			result.put("errorMessage", "강아지 정보를 추가 하는데 실패했습니다.");
		}
		return result;
	}
	
	/**
	 * 반려견 정보 수정 API
	 * @param session
	 * @param dogId
	 * @param dogAge
	 * @param dogWeight
	 * @param file
	 * @return
	 */
	@PostMapping("/update_dog")
	public Map<String, Object> updateDog(
			HttpSession session,
			@RequestParam("dogId") int dogId,
			@RequestParam("dogAge") int dogAge,
			@RequestParam("dogWeight") int dogWeight,
			@RequestParam(value = "file", required = false) MultipartFile file
			) {
		
		// 세션에서 userId, userLoginId 받아오기
		int userId = (int)session.getAttribute("userId");
		String userLoginId = (String)session.getAttribute("userLoginId");
		
		// DB update
		dogBO.updateDog(userId, userLoginId, dogId, dogAge, dogWeight, file);
		
		// 응답
		Map<String, Object> result = new HashMap<>();
		result.put("code", 1);
		result.put("result", "성공");
		return result;
	}
}

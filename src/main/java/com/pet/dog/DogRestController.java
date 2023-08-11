package com.pet.dog;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pet.dog.bo.DogBO;

@RestController
@RequestMapping("/dog")
public class DogRestController {
	
	@Autowired
	private DogBO dogBO;
	
	@PostMapping("/add_dog")
	public Map<String, Object> addDog(
			HttpSession session,
			@RequestParam("dogName") String dogName,
			@RequestParam("dogAge") int dogAge,
			@RequestParam("dogKindId") int dogKindId,
			@RequestParam("dogWeight") int dogWeight
			) {
		
		// 세션에서 userId 받아오기
		int userId = (int)session.getAttribute("userId");
		
		// DB insert
		
		
		Map<String, Object> result = new HashMap<>();
		result.put("code", 1);
		result.put("result", "성공");
		return result;
	}
	
}

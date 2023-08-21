package com.pet.dog;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pet.dog.bo.DogBO;
import com.pet.dog.entity.DogEntity;

@Controller
@RequestMapping("/dog")
public class DogController {
	
	@Autowired
	private DogBO dogBO;

	/**
	 * 반려견 정보 화면
	 * @param session
	 * @param model
	 * @return
	 */
	@GetMapping("/user_dog_view")
	public String userDog(
			HttpSession session,
			Model model) {
		
		// 세션에서 userId 받아오기
		int userId = (int)session.getAttribute("userId");
		
		// DB select
		List<DogEntity> dogEntityList = dogBO.getUserDog(userId);
		
		// 출력
		model.addAttribute("dogEntityList", dogEntityList);
		model.addAttribute("view", "dog/userDog");
		return "template/layout2";
	}
	
	/**
	 * 반려견 추가 화면
	 * @param model
	 * @return
	 */
	@GetMapping("/add_dog_view")
	public String addDogView(Model model) {
		model.addAttribute("view", "dog/addDog");
		return "template/layout2";
	}
	
	/**
	 * 반려견 정보 수정 화면
	 * @param model
	 * @return
	 */
	@GetMapping("/update_dog_view")
	public String updateDogView(Model model) {
		model.addAttribute("view", "dog/updateDog");
		return "template/layout2";
	}
}

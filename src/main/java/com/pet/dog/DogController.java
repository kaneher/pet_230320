package com.pet.dog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dog")
public class DogController {

	/**
	 * 반려견 정보 화면
	 * @param model
	 * @return
	 */
	@GetMapping("/user_dog_view")
	public String userDogView(Model model) {
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
	
}

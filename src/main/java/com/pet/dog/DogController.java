package com.pet.dog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dog")
public class DogController {

	@GetMapping("/user_dog_view")
	public String userDogView(Model model) {
		model.addAttribute("view", "dog/userDog");
		return "template/layout2";
	}
	
}

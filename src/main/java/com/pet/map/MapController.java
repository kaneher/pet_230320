package com.pet.map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/map")
public class MapController {
	
	@GetMapping("/detail_view")
	public String map(Model model) {
		model.addAttribute("view", "map/mapDetail");
		return "template/layout2";
	}
}

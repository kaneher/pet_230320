package com.pet.map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pet.user.bo.UserBO;
import com.pet.user.entity.UserEntity;

@Controller
@RequestMapping("/map")
public class MapController {
	
	@Autowired
	private UserBO userBO;
	
	@GetMapping("/detail_view")
	public String mapDetailView(
			Model model,
			HttpSession session) {
		
		// DB에서 유저 주소 받아오기
		int userId = (int)session.getAttribute("userId");
		UserEntity userEntity = userBO.getUserEntityByUserId(userId);
		
		model.addAttribute("userEntity", userEntity);
		model.addAttribute("view", "map/mapDetail");
		return "template/layout2";
	}
}

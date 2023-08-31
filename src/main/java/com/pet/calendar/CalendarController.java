package com.pet.calendar;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pet.user.bo.UserBO;
import com.pet.user.entity.UserEntity;

@Controller
@RequestMapping("/calendar")
public class CalendarController {
	
	@Autowired
	private UserBO userBO;

	@GetMapping("/detail_view")
	public String calendarDetailView(
			Model model
			, HttpSession session) {
		
		// session에서 userId 받아오기
		int userId = (int)session.getAttribute("userId");
		UserEntity userEntity = userBO.getUserEntityByUserId(userId);
		
		model.addAttribute("userEntity", userEntity);
		model.addAttribute("view", "calendar/calendarDetail");
		return "template/layout2";
	}
}

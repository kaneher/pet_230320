package com.pet.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pet.aop.TimeTrace;
import com.pet.user.bo.UserBO;
import com.pet.user.entity.UserEntity;

@RequestMapping("/user")
@Controller
public class UserController {
	
	@Autowired
	private UserBO userBO;
	
	/**
	 * 회원가입 화면
	 * @param model
	 * @return
	 */
	@TimeTrace
	@GetMapping("/sign_up_view")
	public String signUpView(Model model) {
		model.addAttribute("view", "user/signUp");
		return "template/layout";
	}
	
	/**
	 * 로그인 화면
	 * @param model
	 * @return
	 */
	@TimeTrace
	@GetMapping("/sign_in_view")
	public String signInView(Model model) {
		model.addAttribute("view", "user/signIn");
		return "template/layout";
	}
	
	/**
	 * 로그아웃
	 * @param session
	 * @return
	 */
	@RequestMapping("/sign_out")
	public String signOut(HttpSession session) {
		// 세션에 있는 내용을 비운다.
		session.removeAttribute("userId");
		session.removeAttribute("userLoginId");
		session.removeAttribute("userName");
		
		// 로그인 화면으로 이동 => redirect
		return "redirect:/user/sign_in_view";
	}
	
	/**
	 * 내 정보 상세 화면
	 * @param model
	 * @param session
	 * @return
	 */
	@GetMapping("/information_view")
	public String informationView(
			Model model,
			HttpSession session) {
		
		// userId 받아오기
		int userId = (int)session.getAttribute("userId");
		
		// DB select
		UserEntity userEntity = userBO.getUserEntityByUserId(userId);
		model.addAttribute("userEntity", userEntity);
		model.addAttribute("view", "user/information");
		return "template/layout2";
	}
	
	/**
	 * 내 정보 수정 화면
	 * @param model
	 * @return
	 */
	@GetMapping("/update_user_information_view")
	public String updateUserInformationView(Model model) {
		
		model.addAttribute("view", "user/updateInformation");
		return "template/layout2";
	}
}

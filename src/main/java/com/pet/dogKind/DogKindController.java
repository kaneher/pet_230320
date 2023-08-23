package com.pet.dogKind;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pet.dogKind.bo.DogKindBO;
import com.pet.dogKind.entity.DogKindEntity;

@RequestMapping("/dogKind")
@Controller
public class DogKindController {
	
	@Autowired
	private DogKindBO dogKindBO;
	
	/**
	 * 견종 정보 리스트 페이지
	 * @param model
	 * @return
	 */
	@GetMapping("/list_view")
	public String listView(Model model) {
		
		// DB select
		List<DogKindEntity> dogKindEntityList = dogKindBO.getDogKindList();
		
		model.addAttribute("dogKindEntityList", dogKindEntityList);
		model.addAttribute("view", "dogKind/dogKindList");
		return "template/layout2";
	}
	
	
	@GetMapping("/detail_view")
	public String detailView(
			Model model
			,@RequestParam("dogKindId") int dogKindId) {
		
		DogKindEntity dogKindEntity = new DogKindEntity();
		
		// DB select
		dogKindEntity = dogKindBO.getDogKindById(dogKindId);
		
		model.addAttribute("dogKindEntity", dogKindEntity);
		model.addAttribute("view", "dogKind/dogKindDetail");
		return "template/layout2";
	}
}

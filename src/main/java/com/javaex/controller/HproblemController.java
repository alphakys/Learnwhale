package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.ProblemService;
import com.javaex.vo.CategoryVo;
import com.javaex.vo.ProblemVo;

@Controller
@RequestMapping("/myclass/problem")
public class HproblemController {
	
	@Autowired
	private ProblemService proService;
	
	
	@RequestMapping(value ="/problem-Management", method = { RequestMethod.GET, RequestMethod.POST })
	public String problemManagement(Model model) {
		
		proService.getCategory(2);
		
		model.addAttribute("cateList", proService.getCategory(2));
			
		return "home/problem/problem-Management";
	}

	@RequestMapping(value ="/creatingForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String multipleChoice() {
		System.out.println("[ProblemController.list()]");
		return "home/problem/creatingForm";
	}
	

	@RequestMapping(value ="/main", method = { RequestMethod.GET, RequestMethod.POST })
	public String index() {
		System.out.println("[ProblemController.list()]");
		return "home/main/mainForm";
	}
	
	//메인폴더생성
	@RequestMapping(value = "/addMainFolder", method = {RequestMethod.GET, RequestMethod.POST})
	public String addMainFolder(@ModelAttribute CategoryVo cateVo) {
		System.out.println("[ProblemController.addMainFolder()]");
		proService.addMainFolder(cateVo);
		return "redirect:/myclass/problem/problem-Management";
	}
	
	//하위폴더생성
	@RequestMapping(value = "/addSubFolder", method = {RequestMethod.GET, RequestMethod.POST})
	public String addSubFolder(@ModelAttribute CategoryVo cateVo) {
		System.out.println("[ProblemController.addSubFolder()]");
		return "redirect:/myclass/problem/problem-Management";
	}
	
	//문제관리 리스트
	@RequestMapping(value = "problemList", method = {RequestMethod.GET, RequestMethod.POST})
	public String problemList(Model model, int cateNo) {
		System.out.println("[ProblemController.problemList()]");
		model.addAttribute("cateList", proService.getCategory(2));
		
		model.addAttribute("proList", proService.getProblem(cateNo));
		
		return "home/problem/problemList";
	}
	
	//문제 작성폼
	@RequestMapping(value ="/creating-ViewForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String creatingViewForm() {
		System.out.println("[ProblemController.list()]");
		return "home/problem/creating-ViewForm";
	}
	
	//문제 작성
	@RequestMapping(value ="/creating", method = { RequestMethod.GET, RequestMethod.POST})
	public String creating(@ModelAttribute ProblemVo proVo, @RequestParam("file")MultipartFile file){
		System.out.println("[ProblemController.creating()]");
		
		proService.ProblemInsert(file, proVo);
		
		return "redirect:/home/problem/problemList";
	}
	 
	
	

}
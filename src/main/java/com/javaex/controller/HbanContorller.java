package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/h")
public class HbanContorller {

	@RequestMapping(value="/list", method= {RequestMethod.GET, RequestMethod.POST})
	public String  list() {
		System.out.println("[HbanController.list()]");
		return "home/ban/list";
	}
	
	@RequestMapping(value="/create", method= {RequestMethod.GET, RequestMethod.POST})
	public String made() {
		System.out.println("[HbanController.made()]");
		return "home/ban/createForm";
				
	}
	
	@RequestMapping(value="/modify", method= {RequestMethod.GET, RequestMethod.POST})
	public String plist() {
		System.out.println("[HbanController.modify()]");
		return "home/ban/modifyForm";
				
	}
	
}

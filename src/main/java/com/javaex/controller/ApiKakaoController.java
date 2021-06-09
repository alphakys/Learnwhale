package com.javaex.controller; 

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.ApiService;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping(value="api/kakao")
public class ApiKakaoController {
	
	@Autowired
	private ApiService apiService;
	
	
	@RequestMapping(value="login", method= {RequestMethod.GET, RequestMethod.POST})
	public String login(@RequestParam("code") String code,
						HttpSession session, Model model) {
		String accessToken = apiService.getAccessToken(code);
		session.setAttribute("accessToken", accessToken);
		
		String id = apiService.getData(accessToken);
		
		UserVo usVo = new UserVo();
		usVo.setId(id);
		usVo.setJoinPath("kakao");
		
		UserVo authUser = apiService.checkId(usVo);
		
		if(authUser != null) {
			session.setAttribute("authUser", authUser);
			return "redirect:/myclass/list";
		}
		else {
			model.addAttribute("id", apiService.getData(accessToken));
			model.addAttribute("joinPath", "kakao");
			return "/home/main/joinForm";
		}
		
		
	}

	
	@RequestMapping(value="link", method= {RequestMethod.GET, RequestMethod.POST})
	public String link(HttpSession session) {
		System.out.println("링크");
		String accessToken = (String)session.getAttribute("accessToken");
		
		apiService.link(accessToken);
		
		return "redirect:/api/kakao/";
	}
	
	
	
	@RequestMapping(value="unlink", method= {RequestMethod.GET, RequestMethod.POST})
	public String unlink(HttpSession session) {
		
		String accessToken = (String)session.getAttribute("accessToken");
		
		apiService.unlink(accessToken);
		
		return "redirect:/api/kakao/";
	}
	
	
	
	@RequestMapping(value="logout", method= {RequestMethod.GET, RequestMethod.POST})
	public String logout(HttpSession session) {
		
		String accessToken = (String)session.getAttribute("accessToken");
		
		apiService.logout(accessToken);
		System.out.println(session.getAttribute("accessToken"));
		return "redirect:/api/kakao/";
	}
	
	@RequestMapping(value="getData", method= {RequestMethod.GET, RequestMethod.POST})
	public void getData(HttpSession session) {
	
		String accessToken = (String)session.getAttribute("accessToken");
		
		apiService.getData(accessToken);
	
	}
	
	
	
	
}
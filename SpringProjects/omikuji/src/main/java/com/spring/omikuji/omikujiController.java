package com.spring.omikuji;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class omikujiController { 
	
	@RequestMapping("/omikuji")
		public String index() {  
			return "index.jsp";
		}
		
	@RequestMapping("/login")
		public String login(
			@RequestParam(value="num") Integer num,
			@RequestParam(value="city") String city,
	    	@RequestParam(value="person") String person,
	    	@RequestParam(value="hobby") String hobby,
	    	@RequestParam(value="living") String living,
	    	@RequestParam(value="text") String text,
	    	HttpSession session
	    	){	
	    	session.setAttribute("num", num);
	    	session.setAttribute("city", city); 
	    	session.setAttribute("person", person);
	    	session.setAttribute("hobby", hobby);
	    	session.setAttribute("living", living);
	    	session.setAttribute("text", text);
	    	return "redirect:/omikuji/show";
			}
		
	    	
		@RequestMapping("/omikuji/show")
	    	public String show() {  
		    	return "show.jsp";
				}

}

package com.spring.counter;

import javax.servlet.http.HttpSession;

//import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/your_server")
public class CounterController {
	// ...   
	// ...    
	@RequestMapping("")
	public String index(HttpSession session, Model model) {        
		session.setAttribute("name", "Roaa");
		// Use setAttribute to initialize the count in session
		// If the count is not already in session
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
			// Use setAttribute to initialize the count in session
			
			
		}
		else {
			// increment the count by 1 using getAttribute and setAttribute
			Integer currentCount = (Integer) session.getAttribute("count");
			currentCount++;
			model.addAttribute("countToShow", currentCount);
			session.setAttribute("count", currentCount);
			
		}
			return "index.jsp";
		}
	
	
	@RequestMapping("/counter")
		public String counter(HttpSession session, Model model) {        			
			return "counter.jsp";
		}
	
	@RequestMapping("/increment_by_two")
	public String increment(HttpSession session, Model model) {        
		// If the count is not already in session
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		// Use setAttribute to initialize the count in session

			
		}
		else {
		// increment the count by 1 using getAttribute and setAttribute
			Integer currentCount = (Integer) session.getAttribute("count");
			currentCount+=2;
			model.addAttribute("countToShow", currentCount);
			session.setAttribute("count", currentCount);
			
		}
		
		return "index.jsp";
	}
	@RequestMapping("/counter_zero")
	public String bouns(HttpSession session) {        
		session.setAttribute("count", 0);
			return "counter.jsp";
		}
	// ...

	// ...

}

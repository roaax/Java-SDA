package com.spring.displaydate;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
 

@Controller
public class DisplayDate {
	
	@GetMapping("/")
    public String index() {
        return "index.jsp";
    }
	
	@GetMapping("/date")
    public String date(Model model) {	
		java.util.Date date = new java.util.Date();   
		model.addAttribute("date",date);
        return "date.jsp";
    }
	
	@GetMapping("/time")
    public String time(Model model) {
//		java.time.LocalTime time = new java.time.LocalTime(h, mm, a); 
		java.util.Date time = new java.util.Date(); 
		model.addAttribute("time",time);
        return "time.jsp";
    }
}

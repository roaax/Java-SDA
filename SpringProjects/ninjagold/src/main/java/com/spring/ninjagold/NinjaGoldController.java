package com.spring.ninjagold;

import java.util.Random;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/Gold")
public class NinjaGoldController {
	
	@RequestMapping("")
	public String index(HttpSession session) {  
		if (session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
			
//			Keep a log including the timestamp for each submission.
//			Activity 
			ArrayList<String> activity = new ArrayList<String>();
			session.setAttribute("activity", activity);			
		}
		return "index.jsp";
	}
	
//	@RequestMapping(value="/process", method=RequestMethod.POST) | or
	@PostMapping("/process")
	public String login(@RequestParam(value = "place") String place,HttpSession session) {
		
//		Create date on activity
		LocalDateTime now = LocalDateTime.now();   
	    DateTimeFormatter date = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm a");
	    String formattedDate = now.format(date);  
		
//	    create a list that store a list in the current session 
		@SuppressWarnings("unchecked")
		ArrayList<String> activity = (ArrayList<String>) session.getAttribute("activity");
//		create new variable to store  or get the number of glad in current session
		Integer gold = (Integer) session.getAttribute("gold");
		
//		create a variable that store a (random) | create random object 
		Random r= new Random();
		// generating integer
		int random=r.nextInt();
//		int goldSum=gold + random;
//		int n = r.nextInt(max + 1 - min) + min; | or Math.random
		
		
		if (place.equals("farm")) {
			random=r.nextInt(10,20);
//			 session.setAttribute("gold", goldSum);
//			 just print the message
			activity.add(new String("You entered a "+ place + " and gain" +" "+ random + " gold. (" +formattedDate+ ")"));
		}
		else if (place.equals("cave")) {
			random=r.nextInt(5,10);
//			 session.setAttribute("gold", goldSum);
			activity.add(new String("You entered a "+ place + " and gain" +" "+ random + " gold. (" +formattedDate+ ")"));

		
		}
		else if (place.equals("house")) {
			random=r.nextInt(2,5);
//			 session.setAttribute("gold", goldSum);
			activity.add(new String("You entered a "+ place + " and gain" +" "+ random + " gold. (" +formattedDate+ ")"));	
		}
	        
		else if (place.equals("casino")) {
			random=r.nextInt(-50,50);
			if (random > 0) {
//				session.setAttribute("gold", goldSum);
//			i can also create method to store the message then i add it into log array
				activity.add(new String("You entered a "+ place + " and gain" +" "+ random + " gold. (" +formattedDate+ ")"));
			} else {
//				session.setAttribute("gold", goldSum);
				activity.add(new String("You entered a "+ place + " and lost"+" "+ random + " gold..Ouch.  (" +formattedDate+ ")"));

			}
		}
//	//Optional challenges |	
////		else if (place.equals("spa")) {
////			random=r.nextInt(5,20)-gold;
////			
////		}
//		
		
//		save gold and the the random number in gold
//		session.setAttribute("gold", goldSum);
		
		session.setAttribute("gold", gold + random);
		session.setAttribute("activity", activity);
		
		return "redirect:/Gold";
	}
	
	
//Optional challenges | ● Create a reset button 
	@RequestMapping("/reset")
	public String reset(HttpSession session) {  	
		session.removeAttribute("gold");	
		session.removeAttribute("log");
		return "redirect:/Gold";
	}
}

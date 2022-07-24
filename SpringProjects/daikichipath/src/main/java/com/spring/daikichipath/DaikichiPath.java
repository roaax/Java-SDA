package com.spring.daikichipath;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
@RestController

@RequestMapping("/daikichi")
public class DaikichiPath {

//	@RequestMapping("")
//	public String index(){
//		return "Welcome!";
//	}
//	@RequestMapping("/today")
//	public String today(){
//		return "Today you will find luck in all your endeavors!";
//	}
//	@RequestMapping("/tomorrow")
//	public String tomorrow(){
//		return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
//	}
//	
	/*Add 2 new routes with corresponding method definitions in your
	 *  Daikichi Routes project that will accept path variables.*/
	
	/*
	 * Have an http GET request to 'http://localhost:8080/daikichi/travel/kyoto' 
	 * where the url will take any string for the city, and display text that says 
	 * for example, 'Congratulations! You will soon travel to kyoto!'.
	 */
	    @RequestMapping("travel/{town}")
	    public String daickichi(@PathVariable("town") String town){
	    	return "Congratulations! You will soon travel to " + town ;
	    }
	    
	    
	    /*
	     * Have an http GET request to 'http://localhost:8080/daikichi/lotto/8', 
	     * where the url will take any integer. If the number is even, 
	     * display text that says 'You will take a grand journey in the near future,
	     *  but be weary of tempting offers'. If it is odd, display text that says 
	     *  "You have enjoyed the fruits of your labor but now is a great time to spend
	     *   time with family and friends."*/
	    @RequestMapping("lotto/{num}")
	    public String daickichiTravel(@PathVariable("num") int num){
	    	if(num %2 ==0) {
	    		return "You will take a grand journey in the near future, but be weary of tempting offers " ;
	    	}else {
	    		return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends. " ;
	    	}
	    
	}
}






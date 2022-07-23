package com.spring.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloHuman {
	    @RequestMapping("/")
	    public String index(@RequestParam(value="name", required=false ) String firstName,@RequestParam(value="last_name", required=false )  String lastName) {
	    		
			if(firstName == null ) {
	    		return "Hello Human"; 
	    		
			}else if (firstName != null && lastName != null) {
	    		return "Hello " + firstName + " " + lastName;
			}else {
	    		return "Hello " + firstName ;   	
			}
	    	
	    
	    }
}
/*
 * public String index(@RequestParam(value="name", required=false ) String firstName,@RequestParam(value="last_name", required=false )  String lastName ,@RequestParam(value="times", required=false ) int num) {
 * 	    	String defaultName="";
			for(int i=0 ; i < num ; i++){
				if(firstName == null ) {
					defaultName =defaultName+ " Hello Human";
//	    		return "Hello Human"; 
	    		
				}else if (firstName != null && lastName != null) {
					defaultName =defaultName+  firstName + " " + lastName;
//	    		return "Hello " + firstName + " " + lastName;
				}else {
					defaultName =defaultName+ " Hello " + firstName;
//	    		return "Hello " + firstName ;
//	    	
	    }
	    	
	    }
			return defaultName;
}
 * */




package com.example.springbootrestexample;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
	
	private static final String TEMPLATE = "Hello %s!";
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
		return new Greeting(String.format(TEMPLATE, name));
	}

}

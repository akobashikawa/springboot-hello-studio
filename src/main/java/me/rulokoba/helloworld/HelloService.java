package me.rulokoba.helloworld;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
	
	public String helloWorld() {
		return "Hello World";
	}
	
	public String helloName(String name) {
		if ( name == null || name.equals("") ) {
			name = "Anonymous";
		}
		return "Hello " + name;
	}
	

}

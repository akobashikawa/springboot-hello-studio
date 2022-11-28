package me.rulokoba.helloworld;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
	
	public String helloWorld() {
		return "Hello World";
	}
	
	public String helloName(String name) {
		return "Hello " + name;
	}
	

}

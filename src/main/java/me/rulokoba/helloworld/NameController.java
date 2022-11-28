package me.rulokoba.helloworld;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameController {

	@GetMapping("")
	public String home() {
		return "Hello World Studio";
	}
	
//	@RequestMapping(value="/hello-world", method=RequestMethod.GET)
	@GetMapping("/hello-world")
	public String hello() {
		return "Hello World";
	}
	
	@GetMapping(value = {"/hello-name", "/hello-name/{name}"})
	public String helloName(@PathVariable(required = false) String namePar) {
//	public String helloName(@PathVariable Optional<String> namePar) {
		String name = namePar != null ? namePar : "Anonymous";
//		String name = namePar.isPresent() ? namePar.get() : "Anonymous";
		return "Hello " + name;
	}
	
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "Anonymous") String name) {
		return "Hello " + name;
	}
}

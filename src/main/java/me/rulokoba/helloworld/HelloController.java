package me.rulokoba.helloworld;

import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

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
	
	@PostMapping(value = "/hello-dto", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public HelloResponseDTO helloDto(@RequestBody HelloRequestDTO helloReq) {
		String name = helloReq.getName();
		HelloResponseDTO helloRes = new HelloResponseDTO("Hello " + name);
		return helloRes;
	}
	
	@PostMapping(value = "/hello-dto2", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public ResponseEntity<HelloResponseDTO> helloDto2(@RequestBody Optional<HelloRequestDTO> helloReq) {
		String name = helloReq.isEmpty() ? "Anonymous" : helloReq.get().getName();
		HelloResponseDTO helloRes = new HelloResponseDTO("Hello " + name);
		return ResponseEntity.ok(helloRes);
	}
}

package me.rulokoba.helloworld;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

	@Autowired
	private final HelloService helloService;

	public HelloRestController(HelloService service) {
		this.helloService = service;
	}

//	@GetMapping("")
//	public String home() {
//		return "Hello World Studio";
//	}

	/**
	 * Show hello greeting to world
	 * 
	 * @return String
	 */
//	@RequestMapping(value="/hello-world", method=RequestMethod.GET)
	@GetMapping("/hello-world")
	public String hello() {
		String message = this.helloService.helloWorld();
		return message;
	}

	/**
	 * Show hello greeting to name specified as path param
	 * 
	 * @param namePar
	 * @return String
	 */
	@GetMapping(value = { "/hello-name", "/hello-name/{name}" })
	public String helloName(@PathVariable(value = "name", required = false) String namePar) {
//	public String helloName(@PathVariable Optional<String> namePar) {
		String name = namePar != null ? namePar : "Anonymous";
//		String name = namePar.isPresent() ? namePar.get() : "Anonymous";
		String message = this.helloService.helloName(name);
		return message;
	}

	/**
	 * Show hello greeting to name specified as query param
	 * 
	 * @param name
	 * @return
	 */
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "Anonymous") String name) {
		return "Hello " + name;
	}

	/**
	 * Show json/xml hello greeting to name especified in json form
	 * 
	 * @param helloReq
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@PostMapping(value = "/hello-json", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public HelloResponseDTO helloJson(@RequestBody HelloRequestDTO helloReq) {
		String name = helloReq.getName();
		String message = this.helloService.helloName(name);
		HelloResponseDTO helloRes = new HelloResponseDTO(message);
		return helloRes;
	}

	/**
	 * Show json/xml hello greeting to name especified in json form
	 * 
	 * @param helloReq
	 * @return
	 */
	@PostMapping(value = "/hello-json2", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public ResponseEntity<HelloResponseDTO> helloJson2(@RequestBody Optional<HelloRequestDTO> helloReq) {
		String name = helloReq.isEmpty() ? "Anonymous" : helloReq.get().getName();
		String message = this.helloService.helloName(name);
		HelloResponseDTO helloRes = new HelloResponseDTO(message);
		return ResponseEntity.ok(helloRes);
	}
}

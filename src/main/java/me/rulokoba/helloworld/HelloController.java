package me.rulokoba.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@Autowired
	private final HelloService helloService;

	public HelloController(HelloService service) {
		this.helloService = service;
	}

	/**
	 * Show hello greeting to name specified in x-www-form-urlencoded
	 * 
	 * @param helloReq
	 * @return
	 */
	@PostMapping(value = "/hello-form")
	public String helloForm(@ModelAttribute("helloReq") HelloRequestDTO helloReq, Model model) {
		String name = helloReq.getName();
		String message = this.helloService.helloName(name);
		model.addAttribute("message", message);
		return "hello-form";
	}
	
}

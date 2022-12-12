package me.rulokoba.helloworld;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HelloController {
	
	@Autowired
	private final HelloService helloService;

	@Autowired
	private final NameService nameService;
	
	public HelloController(HelloService helloService, NameService nameService) {
		this.helloService = helloService;
		this.nameService = nameService;
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
	
	/**
	 * Show form.
	 * Show list of names.
	 * 
	 * @param helloReq
	 * @return
	 */
	@GetMapping(value = "/hello-names-form")
	public String helloNamesFormGet(Model model) {
		List<NameEntity> names = this.nameService.findAll();
		model.addAttribute("names", names);
		return "hello-names-form";
	}
	
	/**
	 * Show form.
	 * Show hello greeting.
	 * Show list of names.
	 * 
	 * @param helloReq
	 * @return
	 */
	@PostMapping(value = "/hello-names-form")
	public String helloNamesFormPost(@ModelAttribute("helloReq") HelloRequestDTO helloReq, Model model) {
		String name = helloReq.getName();
		boolean noName = (name == null) || name.equals("");
		boolean isPost = true;
		model.addAttribute("isPost", isPost);
		
		String message = this.helloService.helloName(name);
		model.addAttribute("message", message);
		
		if (!noName) {
			this.nameService.addName(name);
		}
		
		List<NameEntity> names = this.nameService.findAll();
		model.addAttribute("names", names);
		return "hello-names-form";
	}
	
}

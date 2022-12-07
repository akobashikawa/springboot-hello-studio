package me.rulokoba.helloworld;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameController {

	private final NameService personService;

	public NameController(NameService personService) {
		this.personService = personService;
	}
	
	@GetMapping(value = "/people", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Name> getAll() {
		List<Name> result = personService.findAll();
		return result;
	}
	
	@PostMapping(value = "/people", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public Name add(@RequestBody Name person) {
		Name result = personService.save(person);
		return result;
	}
	
	
}
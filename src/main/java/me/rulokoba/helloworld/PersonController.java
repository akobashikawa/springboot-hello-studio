package me.rulokoba.helloworld;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

	private final PersonService personService;

	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	
	@GetMapping("/people")
	public List<Person> getAll() {
		List<Person> result = personService.findAll();
		return result;
	}
	
	@PostMapping("/people")
	public Person add(@RequestBody Person person) {
		Person result = personService.save(person);
		return result;
	}
	
	
}

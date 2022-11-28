package me.rulokoba.helloworld;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
	
	private PersonRepository personRepository;

	public PersonServiceImpl(PersonRepository personRepository) {
		super();
		this.personRepository = personRepository;
	}

	@Override
	public List<Person> findAll() {
		return personRepository.findAll();
	}

	@Override
	public Person save(Person person) {
		return personRepository.save(person);
	}

}

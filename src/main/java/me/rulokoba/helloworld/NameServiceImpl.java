package me.rulokoba.helloworld;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class NameServiceImpl implements NameService {
	
	private NameRepository personRepository;

	public NameServiceImpl(NameRepository personRepository) {
		super();
		this.personRepository = personRepository;
	}

	@Override
	public List<Name> findAll() {
		return personRepository.findAll();
	}

	@Override
	public Name save(Name person) {
		return personRepository.save(person);
	}

}

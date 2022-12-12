package me.rulokoba.helloworld;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class NameServiceImpl implements NameService {
	
	private NameRepository nameRepository;

	public NameServiceImpl(NameRepository nameRepository) {
		super();
		this.nameRepository = nameRepository;
	}

	@Override
	public List<NameEntity> findAll() {
		return nameRepository.findAll();
	}

	@Override
	public NameEntity save(NameEntity name) {
		return nameRepository.save(name);
	}

}

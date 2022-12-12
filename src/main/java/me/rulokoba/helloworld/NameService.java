package me.rulokoba.helloworld;

import java.util.List;

public interface NameService {
	List<NameEntity> findAll();
	NameEntity save(NameEntity name);
	
	default NameEntity addName(String s) {
		NameEntity name = new NameEntity();
		name.setName(s);
		return this.save(name);
	}
}

package me.rulokoba.helloworld;

import java.util.List;

public interface NameService {
	List<Name> findAll();
	Name save(Name name);
	
	default Name addName(String s) {
		Name name = new Name();
		name.setName(s);
		return this.save(name);
	}
}

package me.rulokoba.helloworld;

import java.util.List;

public interface NameService {
	List<Name> findAll();
	Name save(Name person);
}

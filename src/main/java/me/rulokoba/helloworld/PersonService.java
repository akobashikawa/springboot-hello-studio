package me.rulokoba.helloworld;

import java.util.List;

public interface PersonService {
	List<Person> findAll();
	Person save(Person person);
}

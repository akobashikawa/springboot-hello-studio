package me.rulokoba.helloworld;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NameRepository extends JpaRepository<NameEntity, Long> {

}

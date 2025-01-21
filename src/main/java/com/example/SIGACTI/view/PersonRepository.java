package com.example.SIGACTI.view;

import com.example.SIGACTI.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}

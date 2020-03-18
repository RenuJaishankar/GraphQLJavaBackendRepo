package com.example.graphqlproject.Repository;

import com.example.graphqlproject.Model.Animal;
import org.springframework.data.repository.CrudRepository;

public interface AnimalRepository extends CrudRepository<Animal, Long> {
}

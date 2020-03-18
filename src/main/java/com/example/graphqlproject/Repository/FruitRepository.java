package com.example.graphqlproject.Repository;

import com.example.graphqlproject.Model.Fruit;
import org.springframework.data.repository.CrudRepository;

public interface FruitRepository extends CrudRepository<Fruit,Long> {
}

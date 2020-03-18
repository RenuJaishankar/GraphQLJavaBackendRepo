package com.example.graphqlproject.Repository;

import com.example.graphqlproject.Model.ArcadeGame;
import org.springframework.data.repository.CrudRepository;

public interface ArcadeGameRepository extends CrudRepository<ArcadeGame, Long> {
}

package com.adrar.games.repository;

import com.adrar.games.model.Console;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConsoleRepository extends CrudRepository<Console,Integer> {
    Optional<Console> findByName(String name);
}

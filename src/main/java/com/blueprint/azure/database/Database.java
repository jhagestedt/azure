package com.blueprint.azure.database;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface Database extends CrudRepository<DatabaseEntity, Long> {

    @Query(value = "SELECT * FROM ENTITY LIMIT 10",
        countQuery = "SELECT count(*) FROM ENTITY DESC LIMIT 10",
        nativeQuery = true)
    Optional<List<DatabaseEntity>> findByLimit();

}

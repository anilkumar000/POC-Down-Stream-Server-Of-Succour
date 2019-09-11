package com.downStream.cassandra.reactive.repository;

import com.downStream.cassandra.reactive.model.Activities;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuccourCassandraRepository extends ReactiveCassandraRepository<Activities, Integer> {


//    @AllowFiltering
//    Flux<Employe> findByAgeGreaterThan(String name);
}

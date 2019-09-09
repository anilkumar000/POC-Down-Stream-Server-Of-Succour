package com.downStream.cassandra.reactive.repository;

import com.downStream.cassandra.reactive.model.Activities;
import com.downStream.cassandra.reactive.model.Demo;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
//@CassandraType()
public interface SuccourCassandraRepository extends ReactiveCassandraRepository<Activities, Integer> {
//  val ACTOR_TABLE = "CREATE TYPE IF NOT EXISTS actor(objectType text, id text);"


//    @AllowFiltering
//    Flux<Employe> findByAgeGreaterThan(String name);
}

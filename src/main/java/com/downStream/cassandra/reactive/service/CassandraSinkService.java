package com.downStream.cassandra.reactive.service;

import com.downStream.cassandra.reactive.model.Activities;
import com.downStream.cassandra.reactive.repository.SuccourCassandraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class CassandraSinkService implements SinkService {


    SuccourCassandraRepository succourCassandraRepository;
    @Autowired
    public CassandraSinkService(SuccourCassandraRepository succourCassandraRepository){
      this.succourCassandraRepository=succourCassandraRepository;
    }

    @Override
    public void saveActivities(List<Activities> activities) {

         Flux<Activities> demoFlux=succourCassandraRepository.saveAll(activities);
         demoFlux.subscribe(activity-> System.out.println(activity.toString()));

    }
//
//    public Flux<Employe> getAllEmployees() {
//        Flux<Employe> employees =  employeeRepository.findAll();
//        return employees;
//    }

//    public Flux<Employe> getEmployeesFilterByAge(int age) {
//        return employeeRepository.findByAgeGreaterThan(age);
//    }
//
//    public Mono<Employe> getEmployeeById(int id) {
//        return employeeRepository.findById(id);
//    }
}

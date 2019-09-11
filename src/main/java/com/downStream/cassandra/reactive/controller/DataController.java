package com.downStream.cassandra.reactive.controller;


import com.downStream.cassandra.reactive.model.Activities;
import com.downStream.cassandra.reactive.service.CassandraSinkService;
import static com.ibm.common.activitystreams.Makers.activity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.common.activitystreams.Activity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;


import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.ibm.common.activitystreams.Makers.object;


@Controller
public class DataController {

  @Autowired
  CassandraSinkService cassandraSinkService;

  ObjectMapper objectMapper=new ObjectMapper();
  @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;
//  List<Activities> activities = new ArrayList<>();

  Logger logger = LoggerFactory.getLogger("DataController");

  @PostConstruct
  public void saveEmployees() {
    Activity activity =
                activity()
                        .actor(object("person").id("acct:joe@example.org"))
                        .object(object("note").content("my note"))
                        .verb("post")
                        .get();
    kafkaTemplate.send("Succour2",activity.toString());

//        kafkaTemplate.send("Succour",new Demo("anil",22));
//    kafkaTemplate.send("Succour",new Demo("datta",19));

  }

  @KafkaListener(topics="Succour2")
  public void listen(String message) {
    System.out.println("Received Messasge in group - group-id: " + message);
    String json = message;

    try {
      Activities activities = objectMapper.readValue(json, Activities.class);
      logger.info(activities.toString());
      List<Activities> activitiesList=new ArrayList<>();
      activitiesList.add(activities);
      cassandraSinkService.saveActivities(activitiesList);
    } catch (IOException e) {
      e.printStackTrace();
    }


  }


//    @GetMapping("/{id}")
//    public Mono<Employe> getEmployeeById(@PathVariable int id) {
//        return employeeService.getEmployeeById(id);
//    }
//
//    @GetMapping("/filterByAge/{age}")
//    public Flux<Employe> getEmployeesFilterByAge(@PathVariable int age) {
//        return employeeService.getEmployeesFilterByAge(age);
//    }
}

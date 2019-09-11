package com.downStream.cassandra.reactive.service;

import com.downStream.cassandra.reactive.model.Activities;

import java.util.List;

public interface SinkService {
  public void saveActivities(List<Activities> activities);
}

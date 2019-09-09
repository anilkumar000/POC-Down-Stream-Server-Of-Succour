package com.downStream.cassandra.reactive.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class Activities {

    private Actor actor;
    private String verb;
    private ActivityObject object;

}

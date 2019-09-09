package com.downStream.cassandra.reactive.model;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Demo {
  @PrimaryKey
  private String name;
  private int age;
}

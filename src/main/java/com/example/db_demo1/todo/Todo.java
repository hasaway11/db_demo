package com.example.db_demo1.todo;

import lombok.*;

import java.time.*;

@Getter
@Setter
@ToString
public class Todo {
  private int tno;
  private String title;
  private LocalDate regDate = LocalDate.now();
  private boolean finish = false;
}

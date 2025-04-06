package com.example.db_demo1;

import com.example.db_demo1.todo.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;

import java.time.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TodoDaoTest {
  @Autowired
  private TodoDao todoDao;

//  @Test
  public void initTest() {
    assertNotNull(todoDao);
  }

//  @Test
  public void saveTest() {
    Todo todo = Todo.builder().title("영어 공부").memo("5월 토익시험 대비").deadline(LocalDate.of(2025,4,10)).build();
    int result = todoDao.save(todo);
    assertEquals(1, result);
  }

  @Test
  public void findAllTest() {
    List<Todo> todos = todoDao.findAll();
    assertEquals(2, todos.size());
  }
}

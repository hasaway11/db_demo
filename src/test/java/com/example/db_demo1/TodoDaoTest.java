package com.example.db_demo1;

import com.example.db_demo1.todo.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TodoDaoTest {
  @Autowired
  private TodoDao todoDao;

  //@Test
  public void initTest() {
    assertNotNull(todoDao);
  }

  @Test
  public void findAllTest() {
    todoDao.findAll().forEach(a->System.out.println(a));
  }
}

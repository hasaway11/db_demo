package com.example.db_demo1.todo;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class TodoService {
  @Autowired
  private TodoDao todoDao;

  public int save(Todo todo) {
    todoDao.save(todo);
    return todo.getTno();
  }

  public List<Todo> findAll() {
    return todoDao.findAll();
  }

  public Optional<Todo> findById(int tno) {
    return todoDao.findById(tno);
  }

  public boolean finish(int tno) {
    return todoDao.finish(tno)==1;
  }

  public boolean delete(int tno) {
    return todoDao.delete(tno)==1;
  }

}

package com.example.db_demo1.todo;

import org.apache.ibatis.annotations.*;

import java.util.*;

@Mapper
public interface TodoDao {
  @Select("select * from todo")
  List<Todo> findAll();

  @Insert("insert into todo(tno, title, memo, deadline) values(todo_seq.nextval, #{title}, #{memo}, #{deadline})")
  int save(Todo todo);

  @Select("select * from todo where tno=#{tno} and rownum=1")
  Todo findById(int tno);

  @Update("update todo set finish=1 where tno=#{tno} and rownum=1")
  int finish(int tno);

  @Delete("delete from todo where tno=#{tno} and rownum=1")
  int delete(int tno);
}

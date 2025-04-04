package com.example.db_demo1.todo;

import org.apache.ibatis.annotations.*;

import java.util.*;

@Mapper
public interface TodoDao {
  @Select("select * from todo")
  public List<Todo> findAll();

  @SelectKey(statement = "select todo_seq.nextval from dual", keyProperty = "tno", before = true, resultType = Integer.class)
  @Insert("insert into todo(tno, title, memo, reg_date, deadline, finish) values(#{tno}, #{title}, #{memo}, #{regDate}, #{deadline}, #{finish})")
  public int save(Todo todo);

  @Select("select * from todo where tno=#{tno} and rownum=1")
  public Optional<Todo> findById(int tno);

  @Update("update todo set finish=1 where tno=#{tno} and rownum=1")
  public int finish(int tno);

  @Delete("delete from todo where tno=#{tno} and rownum=1")
  public int delete(int tno);
}

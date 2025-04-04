package com.example.db_demo1.supply;

import java.util.*;

import org.apache.ibatis.annotations.*;

@Mapper
public interface SupplyDao {
	@Select("select * from supply")
	public List<Supply> findAll();
	
	@Insert("insert into supply(sno, name,date,count) values(sno_seq.nextval, #{name}, #{date}, #{count})")
	public boolean save(Supply supply);
	
	@Select("select * from supply where sno=#{sno} and rownum=1")
	public Supply findById(int sno);
	
	@Update("update supply set count=count+1 where sno=#{sno} and rownum=1")
	public boolean inc(int sno);
	
	@Update("update supply set count=count+1 where sno=#{sno} and rownum=1")
	public boolean dec(int sno);
	
	@Delete("delete from supply where sno=#{sno} and rownum=1")
	public boolean delete(int sno);
}

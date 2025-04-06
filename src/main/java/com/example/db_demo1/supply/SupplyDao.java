package com.example.db_demo1.supply;

import java.util.*;

import org.apache.ibatis.annotations.*;

@Mapper
public interface SupplyDao {
	@Select("select * from supply")
	List<Supply> findAll();
	
	@Insert("insert into supply(sno, name, quantity) values(supply_seq.nextval, #{name}, #{quantity})")
	boolean save(Supply supply);
	
	@Select("select * from supply where sno=#{sno} and rownum=1")
	Supply findById(int sno);
	
	@Update("update supply set quantity=quantity+1 where sno=#{sno} and rownum=1")
	boolean inc(int sno);
	
	@Update("update supply set quantity=quantity-1 where sno=#{sno} and rownum=1")
	boolean dec(int sno);
	
	@Delete("delete from supply where sno=#{sno} and rownum=1")
	boolean delete(int sno);
}

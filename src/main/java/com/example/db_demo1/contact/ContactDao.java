package com.example.db_demo1.contact;

import java.util.*;

import org.apache.ibatis.annotations.*;

@Mapper
public interface ContactDao {
	@Select(value = "select * from contact")
	public List<Contact> findAll();
	
	@Insert("insert into contact(cno, name, address, tel) values(cno_seq.nextval, #{name}, #{address}, #{tel})")
	public boolean save(Contact contact);
	
	@Select("select * from contact where cno=#{cno} and rownum=1")
	public Contact findById(int cno);
	
	@Update("update contact set address=#{address}, tel=#{tel} where cno=#{cno} and rownum=1")
	public boolean update(Contact contact);
	
	@Delete("delete from contact where cno=#{cno} and rownum=1")
	public boolean delete(int cno);
}

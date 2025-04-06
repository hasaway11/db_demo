package com.example.db_demo1.contact;

import java.util.*;

import org.apache.ibatis.annotations.*;

@Mapper
public interface ContactDao {
	@Select(value = "select * from contact")
	List<Contact> findAll();
	
	@Insert("insert into contact(cno, name, address, tel) values(contact_seq.nextval, #{name}, #{address}, #{tel})")
	boolean save(Contact contact);
	
	@Select("select * from contact where cno=#{cno} and rownum=1")
	Contact findById(int cno);
	
	@Update("update contact set address=#{address}, tel=#{tel} where cno=#{cno} and rownum=1")
	boolean update(Contact contact);
	
	@Delete("delete from contact where cno=#{cno} and rownum=1")
	boolean delete(int cno);
}

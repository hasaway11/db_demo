package com.example.db_demo1.supply;

import java.time.LocalDate;

import lombok.*;

@Getter
@ToString
public class Supply {
	private int sno;
	private String name;
	private LocalDate regDate = LocalDate.now();
	private int quantity;
}

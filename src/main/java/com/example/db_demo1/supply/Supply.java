package com.example.db_demo1.supply;

import java.time.LocalDate;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class Supply {
	private int sno;
	private String name;
	private LocalDate regDate;
	private int quantity;
}

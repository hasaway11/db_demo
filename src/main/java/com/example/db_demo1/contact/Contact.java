package com.example.db_demo1.contact;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class Contact {
	private int cno;
	private String name;
	private String address;
	private String tel;
}

package com.example.demo.model;

import lombok.Data;

@Data
public class MemberInfo {

	private Integer memberId;

	private String lastName;

	private String firstName;

	private String email;

	private String password;

	private String created_at;

	private String update_at;
}

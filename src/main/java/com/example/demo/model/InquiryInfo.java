package com.example.demo.model;

import lombok.Data;

@Data
public class InquiryInfo {

	private Integer inquiryInfoId;

	private String lastName;

	private String firstName;

	private String email;

	private String content;

	private String created_at;

	private String update_at;
}

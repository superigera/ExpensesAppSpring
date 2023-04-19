package com.example.demo.model;

import lombok.Data;

@Data
public class HouseholdAccountBook {

	private Integer recordId;

	private String dating;

	private int amountOfMoney;

	private int categoryId;

	private String categoryName;

	private String remarks;

	private String created_at;

	private String update_at;

}

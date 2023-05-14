package com.example.demo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

@Service
public class CommonServiceImp implements CommonService {

	// 今日を取得
	LocalDate today = LocalDate.now();

	LocalDate beginningMoth = today.withDayOfMonth(1);
	LocalDate endMonth = today.withDayOfMonth(today.lengthOfMonth());

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	String beginningMothStr = beginningMoth.format(formatter);
	String endMonthStr = endMonth.format(formatter);

	/**
	 * 月初の取得
	 * 
	 * @return 月初
	 */
	@Override
	public String getBeginningMoth() {

		return beginningMothStr;
	}

	/**
	 * 月末の取得
	 * 
	 * @return 月末
	 */
	@Override
	public String getEndMoth() {

		return endMonthStr;
	}

}

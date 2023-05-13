package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.InquiryInfo;

@Mapper
public interface InquiryMapper {

	// 問い合わせ内容DB登録
	public void registerInquiryInfo(InquiryInfo InquiryInfo);
}

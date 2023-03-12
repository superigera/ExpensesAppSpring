package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.MemberInfo;

@Mapper
public interface MemberMapper {

	// 新規会員登録
	public void createMember(MemberInfo signupInfo);
}

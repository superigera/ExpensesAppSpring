package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.MemberInfo;
import com.example.demo.repository.MemberMapper;

@Service
public class MemberServiceImp implements MemberService {

	@Autowired
	private MemberMapper memberMapper;

	@Override
	public void createMember(MemberInfo signupInfo) {

		// 新規会員登録
		memberMapper.createMember(signupInfo);

	}

}

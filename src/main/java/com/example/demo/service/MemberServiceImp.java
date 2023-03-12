package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.MemberInfo;
import com.example.demo.repository.MemberMapper;

@Service
public class MemberServiceImp implements MemberService {

	@Autowired
	private MemberMapper memberMapper;

	/**
	 * 新規会員登録
	 * 
	 * 画面からPOSTされた会員情報をDBに登録する
	 * 
	 * @param signupInfo
	 * 
	 */
	public void createMember(MemberInfo signupInfo) {

		// 新規会員登録
		memberMapper.createMember(signupInfo);

	}

}

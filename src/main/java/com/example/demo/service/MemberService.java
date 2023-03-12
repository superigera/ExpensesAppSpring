package com.example.demo.service;

import com.example.demo.model.MemberInfo;

public interface MemberService {

	/**
	 * 新規会員登録
	 * 
	 * 画面からPOSTされた会員情報をDBに登録する
	 * 
	 * @param signupInfo
	 * 
	 */
	public void createMember(MemberInfo signupInfo);
}

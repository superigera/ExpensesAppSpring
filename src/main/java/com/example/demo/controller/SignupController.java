package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.MemberInfo;
import com.example.demo.service.MemberService;

@CrossOrigin
@RestController
public class SignupController {

	@Autowired
	private MemberService memberService;

	/**
	 * 新規会員登録
	 * 
	 * 画面からPOSTされた会員情報をDBに登録する
	 * 
	 * @param signupInfo
	 * 
	 */
	@PostMapping("/signup")
	public void createMember(@RequestBody MemberInfo signupInfo) {
		System.out.println(signupInfo);
		memberService.createMember(signupInfo);
	}
}

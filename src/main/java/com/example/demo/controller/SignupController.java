package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

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
	 * @param 会員情報
	 * 
	 */
	@PostMapping("/signup")
	public void createMember(@RequestBody MemberInfo signupInfo) {

		// 現在日時を取得してsetする
		Date nowDate = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formatNowDate = sdf1.format(nowDate);

		signupInfo.setCreated_at(formatNowDate);
		memberService.createMember(signupInfo);
	}
}

package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.InquiryInfo;
import com.example.demo.service.InquiryService;

@CrossOrigin
@RestController
public class InquiryController {

	@Autowired
	InquiryService inquiryService;

	/**
	 * 問い合わせ受付
	 * 
	 * @param 問い合わせ内容
	 * @throws IOException
	 */
	@PostMapping("/inquiry")
	public String receptionInquiry(@RequestBody InquiryInfo InquiryInfo) throws IOException {

		// 問い合わせ内容をDB登録
		inquiryService.registerInquiryInfo(InquiryInfo);

		// メール送信処理
		inquiryService.sendEmail(InquiryInfo);
		System.out.println(InquiryInfo);
		return "test";
	}
}

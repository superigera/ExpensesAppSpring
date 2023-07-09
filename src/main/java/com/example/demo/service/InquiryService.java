package com.example.demo.service;

import java.io.IOException;
import java.net.URISyntaxException;

import com.example.demo.model.InquiryInfo;

public interface InquiryService {

	/**
	 * 問い合わせDB登録
	 * 
	 * @param 問い合わせ内容
	 */
	public void registerInquiryInfo(InquiryInfo InquiryInfo);

	/**
	 * 問い合わせ内容確認メール送信
	 * 
	 * @param 問い合わせ内容
	 * @throws URISyntaxException
	 */
	public void sendEmail(InquiryInfo InquiryInfo) throws IOException, URISyntaxException;
}

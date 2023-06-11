package com.example.demo.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.InquiryInfo;
import com.example.demo.repository.InquiryMapper;

@Service
public class InquiryServiceImp implements InquiryService {

//	Dotenv dotenv = Dotenv.load();

	@Autowired
	InquiryMapper inquiryMapper;

	/**
	 * 問い合わせDB登録
	 * 
	 * @param 問い合わせ内容
	 */
	@Override
	public void registerInquiryInfo(InquiryInfo InquiryInfo) {

		inquiryMapper.registerInquiryInfo(InquiryInfo);

	}

	/**
	 * 問い合わせ内容確認メール送信
	 * 
	 * @param 問い合わせ内容
	 */
	@Override
	public void sendEmail(InquiryInfo InquiryInfo) throws IOException {

//		String secretKey = dotenv.get("SECRET_KEY");
//		System.out.println(secretKey);

//		try {
//			SendGrid sg = new SendGrid("API:KEY");
//			Request request = new Request();
//			request.setMethod(Method.POST);
//			request.setEndpoint("mail/send");
//			request.setBody(
//					"{\"personalizations\":[{\"to\":[{\"email\":\"super_rigera@icloud.com\"}],\"subject\":\"Sending with Twilio SendGrid is Fun\"}],\"from\":{\"email\":\"test@example.com\"},\"content\":[{\"type\":\"text/plain\",\"value\": \"and easy to do anywhere, even with Java\"}]}");
//			Response response = sg.api(request);
//			System.out.println(response.getStatusCode());
//			System.out.println(response.getBody());
//			System.out.println(response.getHeaders());
//		} catch (IOException ex) {
//			System.out.println(ex);
//			throw ex;
//		}
	}
}

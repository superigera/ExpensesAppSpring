package com.example.demo.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.InquiryInfo;
import com.example.demo.repository.InquiryMapper;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

import io.github.cdimascio.dotenv.Dotenv;

@Service
public class InquiryServiceImp implements InquiryService {

	Dotenv dotenv = Dotenv.load();

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

		try {
			SendGrid sg = new SendGrid(dotenv.get("MAIL_SEND_KEY"));
			Request request = new Request();
			request.setMethod(Method.POST);
			request.setEndpoint("mail/send");
			request.setBody("{\"personalizations\":[{\"to\":[{\"email\":\"sendEmail\"}],"
					+ "\"dynamic_template_data\":{\"name\": \"sendName\", \"content\":\"sendContent\"},"
					+ "\"subject\":\"問い合わせ受付\"}]," + "\"from\":{\"email\":\"test@test.com\"},"
					+ "\"template_id\": \"d-becb29ebce1d45ffa434482458ab356a\"}");
			String replaceBody = request.getBody().replace("sendEmail", InquiryInfo.getEmail())
					.replace("sendName", InquiryInfo.getLastName() + InquiryInfo.getFirstName())
					.replace("sendContent", InquiryInfo.getContent());
			request.setBody(replaceBody);
			System.out.println(request.getBody());
			Response response = sg.api(request);
			System.out.println(response.getStatusCode());
			System.out.println(response.getBody());

		} catch (IOException ex) {
			System.out.println(ex);
			throw ex;
		}
	}
}

package com.example.demo.service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.InquiryInfo;
import com.example.demo.repository.InquiryMapper;

import io.github.cdimascio.dotenv.Dotenv;

@Service
public class InquiryServiceImp implements InquiryService {

	Dotenv dotenv = Dotenv.load();
	private Builder builder;

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
	 * @throws URISyntaxException
	 */
	@Override
	public void sendEmail(InquiryInfo InquiryInfo) throws IOException, URISyntaxException {

		String request = "{\"personalizations\":[{\"to\":[{\"email\":\"sendEmail\"}],"
				+ "\"dynamic_template_data\":{\"name\": \"sendName\", \"content\":\"sendContent\"},"
				+ "\"subject\":\"問い合わせ受付\"}]," + "\"from\":{\"email\":\"test@test.com\"},"
				+ "\"template_id\": \"d-becb29ebce1d45ffa434482458ab356a\"}";
		String replaceBody = request.replace("sendEmail", InquiryInfo.getEmail())
				.replace("sendName", InquiryInfo.getLastName() + InquiryInfo.getFirstName())
				.replace("sendContent", InquiryInfo.getContent());

		String api = dotenv.get("MAIL_SEND_KEY");
		builder = ClientBuilder.newBuilder().build().target(new URI("https://api.sendgrid.com")).path("/v3/mail/send")
				.request(MediaType.APPLICATION_JSON_TYPE).header("Authorization", "Bearer " + api);
		System.out.println(builder);
		Response response = builder.post(Entity.json(replaceBody));
//		try {
//			SendGrid sg = new SendGrid(dotenv.get("MAIL_SEND_KEY"));
//			Request request = new Request();
//			request.setMethod(Method.POST);
//			request.setEndpoint("mail/send");
//			request.setBody("{\"personalizations\":[{\"to\":[{\"email\":\"sendEmail\"}],"
//					+ "\"dynamic_template_data\":{\"name\": \"sendName\", \"content\":\"sendContent\"},"
//					+ "\"subject\":\"問い合わせ受付\"}]," + "\"from\":{\"email\":\"test@test.com\"},"
//					+ "\"template_id\": \"d-becb29ebce1d45ffa434482458ab356a\"}");
//			String replaceBody = request.getBody().replace("sendEmail", InquiryInfo.getEmail())
//					.replace("sendName", InquiryInfo.getLastName() + InquiryInfo.getFirstName())
//					.replace("sendContent", InquiryInfo.getContent());
//			request.setBody(replaceBody);
//			System.out.println(request.getBody());
//			Response response = sg.api(request);
//			System.out.println(response.getStatusCode());
//			System.out.println(response.getBody());
//
//		} catch (IOException ex) {
//			System.out.println(ex);
//			throw ex;
//		}
	}
}
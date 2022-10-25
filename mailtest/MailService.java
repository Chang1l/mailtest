package com.ticket.biz.service;

import javax.mail.internet.InternetAddress;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service("mailService")
public class MailService  {

	@Autowired
	private MailSender mailSender;
	
	
	public void sendEmail(String toAddress, String fromAddress,
					String subject, String msgBody) {
		SimpleMailMessage smm = new SimpleMailMessage();
		InternetAddress addr= new InternetAddress(fromAddress);
		smm.setFrom(addr);//보내는사람
		smm.setTo(toAddress);//받는사람
		smm.setSubject(subject);//제목
		smm.setText(msgBody);//내용
		
		mailSender.send(smm);
	}
}
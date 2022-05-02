package com.ajay.emailprogram.service;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.ajay.emailprogram.pojo.Mail;

@Service
public class EmailServiceImpl implements EmailService{

	@Autowired
	JavaMailSender mailSender;
	
	@Override
	public void sendMail(Mail mail) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
			messageHelper.setSubject(mail.getMailSubject());
			messageHelper.setFrom(new InternetAddress(mail.getMailFrom(),"gmail.com"));
			messageHelper.setTo(mail.getMailTo());
			messageHelper.setText(mail.getMailContent());

			mailSender.send(messageHelper.getMimeMessage());
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

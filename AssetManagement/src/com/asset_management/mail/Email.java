package com.asset_management.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {

	
	
	
	public void sendMail(int userid,String pwd, String designation,String email )
	{
		
		System.out.println(userid);
		System.out.println(pwd);
		System.out.println(designation);
		System.out.println(email);
		
		String to = email;
	      String sub="Asset Managment";
	      
	      
//	      String msg="Welcome at out site and your user id="+userid1+", password="+password1+", designation="+designation1;
	      // Sender's email ID needs to be mentioned
	      String msg="Welcome at Asset Managment and your user id="+userid+", password="+pwd+", Designation="+designation+" Click here to Login =http://192.168.2.128:8080/AssetManagement/otheruser";
	      String from = "wkhan0419@gmail.com";
	      final String username = "wkhan0419@gmail.com";//change accordingly
	      final String password ="10kamilk";//change accordingly
	     // final String designation=designation1;

	      // Assuming you are sending email through relay.jangosmtp.net
	      String host = "smtp.gmail.com";

	      Properties props = new Properties();
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
	      props.put("mail.smtp.host", host);
	      props.put("mail.smtp.port", "587");

	      // Get the Session object.
	      javax.mail.Session session= Session.getInstance(props,new javax.mail.Authenticator() {
	         protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(username, password);
	         }
	      });

	      try {
	         // Create a default MimeMessage object.
	         Message message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field of the header.
	         message.setRecipients(Message.RecipientType.TO,
	         InternetAddress.parse(to));

	         // Set Subject: header field
	         message.setSubject(sub);

	         // Now set the actual message
	         message.setText(msg);

	         // Send message
	         
	         Transport.send(message);
	        System.out.println("Sent message successfully....");
	         } catch (MessagingException e) {
	    	  e.printStackTrace();
	    	     }

	}
}

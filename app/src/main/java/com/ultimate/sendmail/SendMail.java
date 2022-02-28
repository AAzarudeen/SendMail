package com.ultimate.sendmail;

import android.util.Log;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
    SendMail(){
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("EMAILID", "PASSWORD");
                    }
                });
        try {
            MimeMessage mm = new MimeMessage(session);
            mm.setFrom(new InternetAddress("azarcrackzz@gmail.com"));
            mm.addRecipient(Message.RecipientType.TO,new InternetAddress("azarcrackzz@gmail.com"));
            mm.setSubject("Hi ");
            mm.setText("Hi did you ate");
            Transport.send(mm);
        } catch (
                MessagingException e) {
            Log.d("SendMail", e.getMessage());
        }catch (Exception ex){
            System.out.println(ex);
        }
    }
}

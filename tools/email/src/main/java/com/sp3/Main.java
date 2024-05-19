package com.sp3;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import picocli.CommandLine;

import java.util.Properties;

public class Main {
//    public static Properties getEmailProperties() {
//        Properties emailProperties = new Properties();
//        emailProperties.put("mail.smtp.auth", true);
//        emailProperties.put("mail.smtp.starttls.enable", "true");
//        emailProperties.put("mail.smtp.host", "live.smtp.mailtrap.io");
//        emailProperties.put("mail.smtp.port", "587");
//        emailProperties.put("mail.smtp.ssl.trust", "live.smtp.mailtrap.io");
//        return emailProperties;
//    }
//
//    public static void sendMessage(Session session) {
//        try {
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress("mailtrap@demomailtrap.com"));
//            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("sandvikjesse@gmail.com"));
//            message.setSubject("Mail Subject");
//
//            String messageBody = "This is my first email using JavaMailer";
//
//            MimeBodyPart mimeBodyPart = new MimeBodyPart();
//            mimeBodyPart.setContent(messageBody, "text/html; charset=utf-8");
//
//            Multipart multipart = new MimeMultipart();
//            multipart.addBodyPart(mimeBodyPart);
//            message.setContent(multipart);
//            Transport.send(message);
//        } catch (MessagingException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new Email()).execute(args);
        System.exit(exitCode);
//        Properties emailProperties = getEmailProperties();
//        Session emailSession = Session.getInstance(emailProperties, new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication("api", "da169450b514357d3a5109fcdaea7c21");
//            }
//        });
//        sendMessage(emailSession);
    }
}
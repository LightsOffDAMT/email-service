package ru.lightsoff.mailservice.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

@Component
public class GmailService implements EmailService {
    //    private  String GMAIL_USERNAME;
//    private String GMAIL_PASSWORD;
//    private  String GMAIL_HOST;
//    private  String GMAIL_PORT;
    String GMAIL_USERNAME = "???";
    String GMAIL_PASSWORD = "???";
    String GMAIL_HOST = "smtp.gmail.com";
    String GMAIL_PORT = "587";

    Session session;


    public GmailService() {
            Properties props = System.getProperties();
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", GMAIL_HOST);
            props.put("mail.smtp.user", GMAIL_USERNAME);
            props.put("mail.smtp.password", GMAIL_PASSWORD);
            props.put("mail.smtp.port", GMAIL_PORT);
            props.put("mail.smtp.auth", "true");
            session = Session.getDefaultInstance(props);
    }

    public void sendEmail(String subject, String body, List<String> recipientsEmails) throws MessagingException {
            MimeMessage message = createMessage(subject, body);
            InternetAddress[] recipientsAddresses = new InternetAddress[recipientsEmails.size()];
            for (String recipient : recipientsEmails) {
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            }
            sendMessage(message);
    }

    public void sendEmail(String subject, String body, String recipientEmail) {
        try {
            MimeMessage message = createMessage(subject, body);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));
            sendMessage(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private MimeMessage createMessage(String subject, String body) throws MessagingException {
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(GMAIL_USERNAME));
        message.setSubject(subject);
        message.setText(body);
        return message;
    }

    private void sendMessage(Message message) throws MessagingException {
        Transport transport = session.getTransport("smtp");
        transport.connect(GMAIL_HOST, GMAIL_USERNAME, GMAIL_PASSWORD);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }


}

package ru.lightsoff.mailservice.services;

import javax.mail.MessagingException;
import java.util.List;

public interface EmailService {
    void sendEmail(String subject, String body, List<String> recipientsEmails) throws MessagingException;
    void sendEmail(String subject, String body, String recipientEmail) throws MessagingException;
}

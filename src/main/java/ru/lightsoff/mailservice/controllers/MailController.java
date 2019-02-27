package ru.lightsoff.mailservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.lightsoff.mailservice.requests.SendEmailRequest;
import ru.lightsoff.mailservice.services.EmailService;

import javax.mail.MessagingException;
import javax.naming.AuthenticationException;

@RestController
public class MailController {
    @Autowired
    EmailService emailService;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleEmailException(Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }


    @PostMapping("/email/send")
    void login(@RequestBody SendEmailRequest req) throws MessagingException {
        if (req.recipient!=null && req.recipients==null){
                emailService.sendEmail(req.subject, req.body, req.recipient);
        } else if (req.recipient==null && req.recipients!=null){
            emailService.sendEmail(req.subject, req.body, req.recipients);
        } else {
            throw new MessagingException("Specify email one recipient or array of recipients, but not both");
        }
    }
}

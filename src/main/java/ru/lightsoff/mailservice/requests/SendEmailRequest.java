package ru.lightsoff.mailservice.requests;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public class SendEmailRequest {
    public String subject;
    public String body;
    public String recipient;
    public List<String> recipients;
}

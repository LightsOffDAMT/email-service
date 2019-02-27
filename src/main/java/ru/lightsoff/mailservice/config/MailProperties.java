package ru.lightsoff.mailservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "classpath:mail.properties")
@ConfigurationProperties
public class MailProperties {
    private String GMAIL_USERNAME;
    private String GMAIL_PASSWORD;
    private String GMAIL_HOST;
    private String GMAIL_PORT;

    public String getGMAIL_USERNAME() {
        return GMAIL_USERNAME;
    }

    public void setGMAIL_USERNAME(String GMAIL_USERNAME) {
        this.GMAIL_USERNAME = GMAIL_USERNAME;
    }

    public String getGMAIL_PASSWORD() {
        return GMAIL_PASSWORD;
    }

    public void setGMAIL_PASSWORD(String GMAIL_PASSWORD) {
        this.GMAIL_PASSWORD = GMAIL_PASSWORD;
    }

    public String getGMAIL_HOST() {
        return GMAIL_HOST;
    }

    public void setGMAIL_HOST(String GMAIL_HOST) {
        this.GMAIL_HOST = GMAIL_HOST;
    }

    public String getGMAIL_PORT() {
        return GMAIL_PORT;
    }

    public void setGMAIL_PORT(String GMAIL_PORT) {
        this.GMAIL_PORT = GMAIL_PORT;
    }
}

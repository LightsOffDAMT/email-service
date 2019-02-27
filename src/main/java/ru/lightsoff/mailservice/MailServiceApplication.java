package ru.lightsoff.mailservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.lightsoff.mailservice.services.EmailService;

@SpringBootApplication
public class MailServiceApplication {

	public static void main(String[] args) throws Exception{
		ApplicationContext ctx = SpringApplication.run(MailServiceApplication.class, args);
//		EmailService emailService = ctx.getBean(EmailService.class);
//		emailService.sendEmail("something", "something", "derexdahik@yandex.ru");
	}
}

package com.riwi.RiwiMarket.infrastructure.helpers;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class EmailHelper {
    @Autowired
    private final JavaMailSender mailSender;

    //Create methods

    public void sendMailZero(String destination, String nameAdmin, String product, LocalDateTime date){
        MimeMessage message = mailSender.createMimeMessage();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dateToday = date.format(formatter);
        String htmlContent = this.readHTMLTemplate(nameAdmin, product, dateToday, "src/main/resources/emails/email_template.html");

        try {
            message.setFrom(new InternetAddress("springbootmail2024@gmail.com"));
            message.setSubject("Stock Notification");

            message.setRecipients(MimeMessage.RecipientType.TO, destination);
            message.setContent(htmlContent, MediaType.TEXT_HTML_VALUE);

            mailSender.send(message);
            System.out.println("Email sent");
        }catch (Exception e) {
            System.out.println("ERROR: Could not send email" + e.getMessage());
        }
    }

    public void sendMailWarning(String destination, String nameAdmin, String product, LocalDateTime date, String quantity){
        MimeMessage message = mailSender.createMimeMessage();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dateToday = date.format(formatter);
        String htmlContent = this.readHTMLWarning(nameAdmin, product, dateToday, quantity, "src/main/resources/emails/email_warning.html");

        try {
            message.setFrom(new InternetAddress("springbootmail2024@gmail.com"));
            message.setSubject("Stock Warning Notification");

            message.setRecipients(MimeMessage.RecipientType.TO, destination);
            message.setContent(htmlContent, MediaType.TEXT_HTML_VALUE);

            mailSender.send(message);
            System.out.println("Warning Email sent");
        }catch (Exception e) {
            System.out.println("ERROR: Could not send email" + e.getMessage());
        }
    }
    private String readHTMLTemplate(String name, String product, String date, String route){
        //Indicate where is the template
        final Path path = Paths.get(route);

        //Read all lines of th HTML
        try (var lines = Files.lines(path)){
            //Join lines
            var html = lines.collect(Collectors.joining());
            //Replace variables
            return html.replace("{name}", name).replace("{product}", product).replace("{date}", date);
            //Without Exception IOException does not work
        }catch (IOException e){
            System.out.println("Could not read HTML");
            throw  new RuntimeException();
        }
    }

    private String readHTMLWarning(String name, String product, String date, String quantity, String route){
        //Indicate where is the template
        final Path path = Paths.get(route);

        //Read all lines of th HTML
        try (var lines = Files.lines(path)){
            //Join lines
            var html = lines.collect(Collectors.joining());
            //Replace variables
            return html.replace("{name}", name).replace("{product}", product).replace("{date}", date).replace("{quantity}", quantity);
            //Without Exception IOException does not work
        }catch (IOException e){
            System.out.println("Could not read HTML");
            throw  new RuntimeException();
        }
    }
}

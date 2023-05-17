package com.istad.springsecuritybasic.service;


import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.stereotype.Service;

@Service
public class MailingService {

    @Autowired
    JavaMailSender javaMailSender;
   public void sendingEmail(String to , String description, String subject){
       // send for simple message

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(new String[]{"mr.lengseng@gmail.com","sunjessica05@gmail.com","veasnavk711@gmail.com"});
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(description);

        javaMailSender.send(simpleMailMessage);
    }

    public void sendMailWithStyle() throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        // sender
        message.setFrom(new InternetAddress("lyvanna544@gmail.com"));
        // recriever
        message.setRecipients(MimeMessage.RecipientType.TO, "keokay888@gmail.com");
        // content will be sent to the clients
        String messageContent= """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta http-equiv="X-UA-Compatible" content="IE=edge">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Document</title>
                                
                     <style>
                        .reciever{
                            color: orange;
                        }
                                
                        .token{
                            font-size: 40px;
                            font-weight: bold;
                            color: orange;
                        }
                     </style>
                </head>
                <body>
                   \s
                        <h1> Greeting from <span class="reciever"> Bona </span></h1>
                        <p> here is your token <span class="token"> 1234567</span> </p>
                                
                                
                </body>
                </html>
                                
                """;
        message.setContent(messageContent, "text/html; charset=utf-8");
        javaMailSender.send(message);
    }

}

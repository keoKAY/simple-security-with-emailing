package com.istad.springsecuritybasic.controller;


import com.istad.springsecuritybasic.service.MailingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class MailingRestController {
    private final MailingService mailingService;

    MailingRestController(MailingService mailingService) {
        this.mailingService = mailingService;
    }

    @PostMapping("/sendingmail")
    public String sendMail() {
        try {
            mailingService.sendingEmail("keokay888@gmail.com", "Here is the description ", "Sending from the application ");
            return "Successfully sending mail ";
        } catch (Exception ex) {
            System.out.println("Ex : " + ex.getMessage());
            return " Failed to send mail ";
        }
    }

    @PostMapping("/sending-styled-mail")
    public String sendingBetterMail(){
        try{
            mailingService.sendMailWithStyle();
            return "Successfully sending mail !";
        }catch (Exception ex){
            ex.printStackTrace();
            return "Failed to send the html mail ";
        }
    }
}

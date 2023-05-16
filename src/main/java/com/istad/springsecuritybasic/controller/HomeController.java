package com.istad.springsecuritybasic.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/homepage")
    public String homepage(){
        return " this is the public homepage ";
    }

    @GetMapping("/feed")
    public String feed(){
        return " this is the public feed ";
    }

}

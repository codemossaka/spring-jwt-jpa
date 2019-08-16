package com.example.securityapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController

public class HomeController {

    @GetMapping(value = "/items")
    public ArrayList<String> index(){
        ArrayList<String> list = new ArrayList<>();
        list.add("Text 1");
        list.add("Text 2");
        list.add("Text 3");
        list.add("Text 4");
        return list;
    }
}

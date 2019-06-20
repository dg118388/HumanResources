package com.sd.demo.controller;


import com.sd.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
public class HelloWorld {

    @Autowired
    private UserService userService;



    @RequestMapping(name = "/ahah")
    public String aHaa(){

        return userService.getUserById(1).getName()+"";
    }
}

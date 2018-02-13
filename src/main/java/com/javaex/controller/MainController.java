package com.javaex.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class MainController {
    @RequestMapping(value="", method=RequestMethod.GET)
    public String main(){
        System.out.println("INDEX TEST 진입");
        return "/main/index";
    }
}
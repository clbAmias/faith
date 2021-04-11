package com.qd.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final Logger logger = Logger.getLogger(getClass());


    @RequestMapping(value = "/hello")
    public String index() {
        return "hello world";
    }




}

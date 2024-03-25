package com.merriment.customerservice.controller;

import com.merriment.customerservice.model.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/register/{type}")
public class RegistrationController {

    @PutMapping
    public ResponseBody register(@PathVariable String type){

        return null;
    }

}

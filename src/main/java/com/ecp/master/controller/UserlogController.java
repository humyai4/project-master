package com.ecp.master.controller;

import com.ecp.master.model.service.UserlogRepository;
import com.ecp.master.model.table.Userlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/userlog")
@RestController

public class UserlogController {
    @Autowired
    private UserlogRepository userlogRepository;

    @GetMapping("log")
    private  Object log(Userlog userlog){
        userlogRepository.findAll();
        return  userlogRepository.findAll();
    }
}

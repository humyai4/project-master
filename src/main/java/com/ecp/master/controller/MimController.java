package com.ecp.master.controller;


import com.ecp.master.model.service.MimRepository;
import com.ecp.master.model.table.Mim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RequestMapping("/mim")
@RestController
public class MimController {
    @Autowired
    private MimRepository mimRepository;

    @GetMapping("/list")
    public Object list(Mim mim){
        mimRepository.findAll();
        return  mimRepository.findAll();
    }
}

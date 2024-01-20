package com.ecp.master.controller;


import com.ecp.master.model.bean.APIResponse;
import com.ecp.master.model.service.PerformRepository;
import com.ecp.master.model.table.Perform;
import org.springframework.beans.AbstractPropertyAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("/perform")
@RestController
public class PerformController {
    @Autowired
    private PerformRepository performRepository;

    @GetMapping("perform")
    private Object perform(Perform perform){
        performRepository.findAll();
        return  performRepository.findAll();
    }

    @GetMapping("/performImgCheck")
    private  Object Img(@RequestParam Integer Img){
        long performImg = Img;
        return  performRepository.findByPerformImg(performImg);
    }

    @PostMapping("/checkPerform")
    private Object checkPerform(Perform perform){
        APIResponse response = new APIResponse();
        Perform check = performRepository.findByPerformImg(perform.getPerformImg());
        if (check != null){
            response.setStatus(1);
        }else {
            response.setStatus(2);
        }
        return response;
    }




    @GetMapping("/performuser")
    private Object user(@RequestParam Integer user){
        long id = user;
        return  performRepository.findByPerformUser(id);
    }

    @PostMapping("/performupdate")
    private Object performupdate(Perform perform){
        APIResponse response = new APIResponse();
        performRepository.save(perform);
        response.setMessage("Update Success");
        response.setData(perform.getPerformId());
        return response;
    }


}

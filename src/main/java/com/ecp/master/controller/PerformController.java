package com.ecp.master.controller;

import com.ecp.master.model.bean.APIResponse;
import com.ecp.master.model.service.PerformRepository;
import com.ecp.master.model.table.News;
import com.ecp.master.model.table.Perform;
import com.ecp.master.model.table.User;
import com.ecp.master.util.ResourceIdGenerate;
import org.springframework.beans.AbstractPropertyAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

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

    @GetMapping("/performuser")
    private Object user(@RequestParam Integer user){
        long id = user;
        return  performRepository.findByPerformUser(id);
    }

    @GetMapping ("/performId")
    private Object performid(@RequestParam Integer performid){
        long performId = performid;
        return performRepository.findByPerformId(performId);
    }
    @PostMapping("/performupdate")
    private Object performupdate(Perform perform, @RequestParam("picture") MultipartFile file){
        APIResponse response = new APIResponse();
        String nameImage = "%s.png".formatted(new ResourceIdGenerate().resourceId());
        String part = "D:\\SCR\\projectUI\\src\\assets\\newsImg\\";
        File file1 = new File("%s%s".formatted(part,nameImage));
        try {
            file.transferTo(file1);
            perform.setPerformImg(nameImage);
            performRepository.save(perform);
            response.setMessage("Update Success");
            response.setData(perform.getPerformId());
        } catch (Exception e){
            response.setStatus(12);
            response.setMessage("err");
        }
        return response;
    }
    @PostMapping("/performupdateImg")
    private Object performupdateImg(Perform perform){
        APIResponse response = new APIResponse();
        performRepository.save(perform);
        response.setStatus(1);
        return response;
    }
    @PostMapping("/delete")
    public  Object delete(Perform perform){
        APIResponse response = new APIResponse();
        performRepository.delete(perform);
        response.setMessage("success");
        return response;
    }


}

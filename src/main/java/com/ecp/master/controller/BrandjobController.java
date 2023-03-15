package com.ecp.master.controller;


import com.ecp.master.model.bean.APIResponse;
import com.ecp.master.model.service.BrandjobRepository;
import com.ecp.master.model.table.Brandjob;
import com.ecp.master.model.table.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RequestMapping("/brandjob")
@RestController

public class BrandjobController {
    @Autowired
    private BrandjobRepository brandjobRepository;

    //FINDBYID
    //EXAMPLE "http://180.183.246.177:1114/brandjob/jobid?job=2"
    @GetMapping("/jobid")
    private Object job(@RequestParam Integer job){
        int id = job;
        return  brandjobRepository.findById(id);
    }

    @GetMapping("/jobs")
    private Object jobs(@RequestParam("job") List<Integer>id){
        System.out.print(id);
        System.out.print(".............................................................");
        System.out.print(brandjobRepository.findAllById(id));
        return id;
    }

    @GetMapping("/userid")
    private Object user(@RequestParam Integer user){
        int id = user;
        return  brandjobRepository.findByUserId(id);
    }

    @GetMapping("/job")
    public  Object job(Brandjob brandjob){
        brandjobRepository.findAll();
        return  brandjobRepository.findAll();
    }

    @PostMapping("/jobcreate")
    public Object jobcreate(Brandjob brandjob){
        APIResponse response = new APIResponse();
        try {
            Brandjob checkRegister = brandjobRepository.findByBjName(brandjob.getBjName());
            if (checkRegister == null){
                brandjob.setActive("ทำการสร้างการหางาน");
                brandjobRepository.save(brandjob);
                System.out.print(brandjob);
                response.setMessage("JobCreateSuccess");
                response.setData(brandjob.getId());
                response.setStatus(1);
            } else {
                response.setMessage("ชื่อซ้ำ");
                response.setStatus(0);
            }
//            return  response
        }catch (Exception e){
            response.setStatus(0);
            response.setMessage("ระบบขัดข้อง");
        }
        return  response;
    }

    @PostMapping("/jobDelete")
    public  Object delete(Brandjob brandjob){
        APIResponse response = new APIResponse();
        brandjobRepository.delete(brandjob);
        response.setMessage("success");
        return response;
    }


}

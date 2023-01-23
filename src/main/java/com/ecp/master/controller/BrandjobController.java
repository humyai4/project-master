package com.ecp.master.controller;


import com.ecp.master.model.bean.APIResponse;
import com.ecp.master.model.service.BrandjobRepository;
import com.ecp.master.model.table.Brandjob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("/brandjob")
@RestController

public class BrandjobController {
    @Autowired
    private BrandjobRepository brandjobRepository;


    @GetMapping("/jobid")
    private Object job(@RequestParam Integer job){
        int id = job;
        return  brandjobRepository.findById(id);
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
            brandjobRepository.save(brandjob);
            System.out.print(brandjob);
            response.setMessage("JobCreateSuccess");
            response.setData(brandjob.getId());
            response.setStatus(1);
//            return  response
        }catch (Exception e){
            response.setStatus(0);
            response.setMessage("ระบบขัดข้อง");
        }
        return  response;
    }


}

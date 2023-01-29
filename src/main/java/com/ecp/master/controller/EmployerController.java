package com.ecp.master.controller;


import com.ecp.master.model.bean.APIResponse;
import com.ecp.master.model.service.EmployerjobRepository;
import com.ecp.master.model.table.Brandjob;
import com.ecp.master.model.table.Employerjob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("/employerjob")
@RestController

public class EmployerController {
    @Autowired
    private EmployerjobRepository employerjobRepository;

    @GetMapping("/empjob")
    private Object empjob(Employerjob employerjob){
        employerjobRepository.findAll();
        return employerjobRepository.findAll();
    }

    //FINDBYID
    //EXAMPLE"http://180.183.246.177:1114/employerjob/empjobid?job=1"
    @GetMapping("/empjobid")
    private Object job(@RequestParam Integer job){
        int id = job;
        return  employerjobRepository.findById(id);
    }

    @PostMapping("/jobcreate")
    public Object jobcreate(Employerjob employerjob){
        APIResponse response = new APIResponse();
        try {
            Employerjob checkRegister = employerjobRepository.findByEjName(employerjob.getEjName());
            if (checkRegister == null){
//                brandjob.setActive("ทำการสร้างการหางาน");
                employerjobRepository.save(employerjob);
                System.out.print(employerjob);
                response.setMessage("JobCreateSuccess");
                response.setData(employerjob.getId());
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
    public  Object delete(Employerjob employerjob){
        APIResponse response = new APIResponse();
        employerjobRepository.delete(employerjob);
        response.setMessage("success");
        return response;
    }
}

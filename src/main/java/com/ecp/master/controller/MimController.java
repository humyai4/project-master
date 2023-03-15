package com.ecp.master.controller;


import com.ecp.master.model.bean.APIResponse;
import com.ecp.master.model.service.MimRepository;
import com.ecp.master.model.table.Employerjob;
import com.ecp.master.model.table.Mim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    //EXAMPLE"http://180.183.246.177:1114/mim/mimid?mim=1"
    @GetMapping("/mimid")
    private Object mim(@RequestParam Integer mim){
        int id = mim;
        return  mimRepository.findByMimId(id);
    }
    @PostMapping("/mimcreate")
    public  Object mimcreate(Mim mim){
        APIResponse response = new APIResponse();
        try {
            Mim checkCreate = mimRepository.findByMimName(mim.getMimName());
            if (checkCreate == null){
                mimRepository.save(mim);
                response.setStatus(1);
                response.setMessage("Mim Create Success");
            } else {
                response.setStatus(0);
                response.setMessage("ชื่อซ้ำ");
            }
        }catch (Exception e){
            response.setStatus(0);
            response.setMessage("ระบบขัดข้อง");
        }
        return  response;
    }

    @PostMapping("/mimdelete")
    public  Object delete(Mim mim){
        APIResponse response = new APIResponse();
        mimRepository.delete(mim);
        response.setMessage("delete success");
        return response;
    }
}

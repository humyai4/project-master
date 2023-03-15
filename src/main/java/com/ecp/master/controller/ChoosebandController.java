package com.ecp.master.controller;

import com.ecp.master.model.bean.APIResponse;
import com.ecp.master.model.service.ChooseRepository;
import com.ecp.master.model.table.Chooseband;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin ("*")
@RequestMapping("/choose")
@RestController
public class ChoosebandController {
    @Autowired
    private ChooseRepository chooseRepository;

    @GetMapping("/chooseband")
    private  Object chooseband(Chooseband chooseband){
        chooseRepository.findAll();
        return  chooseRepository.findAll();
    }
    @GetMapping("/choosebandid")
    private Object emp(@RequestParam Integer emp){
        int empId = emp;
        return  chooseRepository.findByEmpId(empId);
    }

    @PostMapping("/createorder")
    private Object createorder(Chooseband chooseband) {
        APIResponse response = new APIResponse();
        try {
            chooseRepository.save(chooseband);
            response.setStatus(1);
        } catch (Exception e) {
            response.setStatus(0);
        }
        return response;
    }
}

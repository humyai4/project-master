package com.ecp.master.controller;

import com.ecp.master.model.bean.APIResponse;
import com.ecp.master.model.service.ChooseRepository;
import com.ecp.master.model.table.Chooseband;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Date;


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

    @GetMapping("/choosebandBj")
    private  Object bjid(@RequestParam Integer bjid){
        int bjId = bjid;
        return  chooseRepository.findByBjId(bjId);
    }

    @GetMapping("/choosebanduserid")
    private Object userid(@RequestParam Integer userid){
        int userId = userid;
        return chooseRepository.findByUserId(userId);
    }

    @PostMapping("/createorder")
    private Object createorder(Chooseband chooseband) {
        APIResponse response = new APIResponse();
        Optional<Chooseband> kuy = chooseRepository.findByBjIdAndEmpId(chooseband.getBjId(), chooseband.getEmpId());

        if(kuy.isPresent()){
            kuy.get().setDateCreate(new Date());
            try {
                chooseRepository.save(kuy.get());
                response.setStatus(1);
            } catch (Exception e){
                response.setStatus(0);
                response.setMessage(e.getMessage());
            }
        } else{
            response.setStatus(0);
            response.setMessage("Data not found by key : " + chooseband.getBjId()+ "...and..." + chooseband.getEmpId());
            chooseRepository.save(chooseband);
        }
//       try {
//            //chooseRepository.save(chooseband);
//            response.setStatus(1);
//        } catch (Exception e) {
//            response.setStatus(0);
//        }
//        chooseRepository.findByBjIdAndEmpId(chooseband.getBjId(), chooseband.getEmpId());
        System.out.print("..=...=...=..=."+chooseRepository.findByBjIdAndEmpId(chooseband.getBjId(), chooseband.getEmpId()));
        return response;
    }

    @PostMapping("/choosebandDelete")
    public  Object delete(Chooseband chooseband){
        APIResponse response = new APIResponse();
        chooseRepository.delete(chooseband);
        response.setMessage("success");
        return  response;
    }

    @PostMapping("/choosebandDeleteBjId")
    public Object deleteBj(Chooseband chooseband) {
        APIResponse response = new APIResponse();
        try {
            chooseRepository.deleteByBjId(chooseband.getBjId());
            response.setStatus(1);
            response.setMessage("successss");
        } catch (Exception e){
            response.setStatus(0);
            response.setMessage(e.getMessage());
        }

        return response;
    }

}

package com.ecp.master.controller;

import com.ecp.master.model.bean.APIResponse;
import com.ecp.master.model.service.ChooseRepository;
import com.ecp.master.model.table.Chooseband;
import com.ecp.master.model.table.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Date;


@CrossOrigin ("*")
@RequestMapping("/choose")
@RestController
public class ChoosebandController {

    @Autowired
    private ChooseRepository chooseRepository;
    public  ChoosebandController(ChooseRepository chooseRepository){
        this.chooseRepository = chooseRepository;
    }

    @GetMapping("/getstatus")
    public ResponseEntity<List<Chooseband>> getByUserIdAndStatus(
            @RequestParam long userId,
            @RequestParam int status
    ){
        APIResponse response = new APIResponse();
        List<Chooseband> result = chooseRepository.findByUserIdAndStatus(userId,status);
        if(!result.isEmpty()){
            return new ResponseEntity<>(result, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/getstatuszero")
    public ResponseEntity<List<Chooseband>> getByEmpIdAndStatus(
            @RequestParam long empId,
            @RequestParam int status
    ){
        APIResponse response = new APIResponse();
        List<Chooseband> result = chooseRepository.findByEmpIdAndStatus(empId,status);
        if(!result.isEmpty()){
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/chooseband")
    private  Object chooseband(Chooseband chooseband){
        chooseRepository.findAll();
        return  chooseRepository.findAll();
    }

    @GetMapping("/choosid")
    private Object cid(@RequestParam Integer cid){
        long id = cid;
        return  chooseRepository.findById(id);
    }

    @GetMapping("/choosebandid")
    private Object emp(@RequestParam Integer emp){
        int empId = emp;
        return  chooseRepository.findByEmpId(empId);
    }

    @GetMapping("/chooseBandStatus")
    private Object status(@RequestParam Integer status){
        int bandStatus = status;
        return  chooseRepository.findByStatus(bandStatus);
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
            response.setStatus(0);
            response.setMessage("sussess");
            chooseRepository.save(chooseband);
        return response;
    }

    @PostMapping("/choosebandDelete")
    public  Object delete(Chooseband chooseband){
        APIResponse response = new APIResponse();
        chooseRepository.delete(chooseband);
        response.setMessage("success");
        return  response;
    }

    @PostMapping("/choosebandupdate")
    public  Object update(Chooseband chooseband){
        APIResponse response = new APIResponse();
        chooseRepository.save(chooseband);
        System.out.print(chooseband);
        response.setMessage("success");
        return response;
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

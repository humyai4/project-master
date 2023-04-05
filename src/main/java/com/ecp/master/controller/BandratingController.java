package com.ecp.master.controller;


import com.ecp.master.model.bean.APIResponse;
import com.ecp.master.model.service.BandratingRepository;
import com.ecp.master.model.table.Bandrating;
import com.ecp.master.model.table.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RequestMapping("/rating")
@RestController


public class BandratingController {

    @Autowired
    private BandratingRepository bandratingRepository;

    @GetMapping("/rateList")
    private Object rateList(Bandrating bandrating) {
        bandratingRepository.findAll();
        return bandratingRepository.findAll();
    }
    @GetMapping("/rateId")
    private Object rateid(@RequestParam Integer chid){
        long chId = chid;
        return  bandratingRepository.findByChId(chId);
    }

    @GetMapping("/bjrating")
    public Object bjrating(@RequestParam Integer bjid){
        int bjId = bjid;
        return  bandratingRepository.findByBjId(bjId);
    }

    @PostMapping("/giverate")
    public  Object update (Bandrating bandrating){
        APIResponse response = new APIResponse();
        bandratingRepository.save(bandrating);
        response.setMessage("suc");
        return response;
    }
}

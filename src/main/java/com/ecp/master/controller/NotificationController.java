package com.ecp.master.controller;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.ecp.master.model.bean.APIResponse;
import com.ecp.master.model.service.NotificationRepository;
import com.ecp.master.model.table.Chooseband;
import com.ecp.master.model.table.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@CrossOrigin("*")
@RequestMapping("/noti")
@RestController
public class NotificationController {
    @Autowired
    private NotificationRepository notificationRepository;

    @GetMapping("/getstatus")
    public ResponseEntity<List<Notification>> getByUserIdToAndReadstatus(
            @RequestParam int userIdTo,
            @RequestParam String readstatus
    ){
        APIResponse response = new APIResponse();
        List<Notification> result = notificationRepository.findByUserIdToAndReadstatus(userIdTo,readstatus);
        if(!result.isEmpty()){
            return  new ResponseEntity<>(result, HttpStatus.OK);
        }else {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getallnoti")
    private Object getnoti(Notification notification){
        notificationRepository.findAll();
        return  notificationRepository.findAll();
    }

    @GetMapping("/getbyid")
    private  Object id(@RequestParam Integer notiid){
        int notiId = notiid;
        return  notificationRepository.findByNotiId(notiId);
    }
    @GetMapping("/getbyuserid") //empId
    private  Object userid(@RequestParam Integer userid){
        int id = userid;
        return  notificationRepository.findByUserIdTo(id);
    }

    @PostMapping("/createnoti")
    private Object createnoti(Notification notification){
        APIResponse response = new APIResponse();
        try {
            notificationRepository.save(notification);
            response.setStatus(1);
        }catch (Exception e) {
        response.setStatus(0);
        }
        return response;
        }

    @PostMapping("/notiupdate")
    public  Object update(Notification notification){
        APIResponse response = new APIResponse();
        notificationRepository.save(notification);
        response.setMessage("success");
        return response;
    }
    }



package com.ecp.master.controller;

import com.ecp.master.model.bean.APIResponse;
import com.ecp.master.model.service.NotificationRepository;
import com.ecp.master.model.table.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RequestMapping("/noti")
@RestController
public class NotificationController {
    @Autowired
    private NotificationRepository notificationRepository;

    @GetMapping("/getallnoti")
    private Object getnoti(Notification notification){
        notificationRepository.findAll();
        return  notificationRepository.findAll();
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
    }



package com.ecp.master.controller;


import com.ecp.master.model.bean.APIResponse;
import com.ecp.master.model.service.UserRepository;
import com.ecp.master.model.table.Brandjob;
import com.ecp.master.model.table.User;
//import com.ecp.master.util.EncoderUtil;
import com.ecp.master.util.ResourceIdGenerate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import  javax.servlet.http.HttpSession;
import java.io.File;


@CrossOrigin("*")
@RequestMapping("/user")
@RestController

public class UserController {


    @Autowired
    private UserRepository userRepository;


    //USERBYID
    @GetMapping("/userid")
    private Object userList(@RequestParam Integer user){
        int id = user;
        return userRepository.findById(id);
    }

    @GetMapping("/userrole")
    private  Object userroles(@RequestParam Integer userroles){
        long role = userroles;
        return userRepository.findByRole(role);
    }

    @GetMapping("/userList")
    public  Object userList(User user){
        userRepository.findAll();
        return userRepository.findAll();
    }

    @PostMapping("/updatestring")
    public  Object update(User user){
        APIResponse response = new APIResponse();
        userRepository.save(user);
        System.out.print(user);
        response.setData(user.getEmail());
        response.setMessage("success");
        return response;
    }
    //UPDATE
    @PostMapping("/update")
    public  Object update(User user,@RequestParam("picture") MultipartFile file){
        APIResponse response = new APIResponse();
        String nameImage = "%s.png".formatted(new ResourceIdGenerate().resourceId());
        String part = "D:\\SCR\\projectUI\\src\\assets\\newsImg\\";
        File file1 = new File("%s%s".formatted(part,nameImage));
        try {
            file.transferTo(file1);
            user.setProfileImg(nameImage);
            userRepository.save(user);
            System.out.print(user);
            response.setData(user.getEmail());
            response.setMessage("success");
        }catch (Exception e){
            response.setStatus(12);
            response.setMessage("err");
        }
        return response;
    }


    //REGISTER
    @PostMapping("/register")
    public Object register(User user){
        APIResponse response = new APIResponse();
        try {
            User checkRegister = userRepository.findByEmail(user.getEmail());
            if (checkRegister == null){
                userRepository.save(user);
                System.out.print(user);
                response.setData(user.getEmail());
                response.setMessage("สมัครสมาชิกสำเร็จ");

            } else {
                response.setMessage("อีเมลซ้ำ!!");
                response.setStatus(1);
            }
            }catch (Exception e){
            response.setStatus(11);
//            response.setData(encoderUtil);
            response.setMessage("error");
        }
        return response;

        }
    @PostMapping("/checkEmail")
    public Object checkEmail(User user){
        APIResponse response = new APIResponse();
        try {
            User CheckEmail = userRepository.findByEmail(user.getEmail());
            if (CheckEmail == null){
                response.setMessage("ไม่ซ้ำ");
                response.setStatus(1);
            }else {
                response.setMessage("ซ้ำ");
                response.setStatus(0);
            }
        }catch (Exception e){
            response.setStatus(11);
            response.setMessage("error");
        }
        return response;
    }

    //LOGIN
    @PostMapping("/login")
    public Object login(User user){
        APIResponse response = new APIResponse();

        try {
            User checkUserAndPass = userRepository.findByEmailAndPassword(user.getEmail(),user.getPassword());
            if (checkUserAndPass != null){

//                encoderUtil.passwordEncoder();

                response.setStatus(1);
                response.setMessage("ล็อกอินสำเร็จ");
                response.setData(checkUserAndPass.getUsername());
                response.setData2(checkUserAndPass.getId());
                response.setDataRole(checkUserAndPass.getRole());
                System.out.print(checkUserAndPass);

            }else {
                response.setStatus(0);
                response.setMessage("เช็ค Email และ Password");
                System.out.print(userRepository);
                response.setData(user.getPassword());
            }

        }catch (Exception err){
            response.setMessage(err.toString());
        }
        return response;
    }
    @PostMapping("/delete")
    public  Object delete(User user){
        APIResponse response = new APIResponse();
        userRepository.delete(user);
        response.setMessage("success");
        return response;
    }

    }




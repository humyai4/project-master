package com.ecp.master.controller;


import com.ecp.master.model.bean.APIResponse;
import com.ecp.master.model.service.UserRepository;
import com.ecp.master.model.table.User;
//import com.ecp.master.util.EncoderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import  javax.servlet.http.HttpSession;


@CrossOrigin
@RequestMapping("/user")
@RestController

public class UserController {
//
//    @Autowired
//    private EncoderUtil encoderUtil;

    @Autowired
    private UserRepository userRepository;


    //USERBYID
    @GetMapping("/userid")
    private Object userList(@RequestParam Integer user){
//        userRepository.findById(id);
        int id = user;
        return userRepository.findById(id);
//        return "ID: " + id;
    }

    @GetMapping("/userList")
    public  Object userList(User user){
        userRepository.findAll();
        return userRepository.findAll();
    }


    //UPDATE
    @PostMapping("/update")
    public  Object update(User user){
        APIResponse response = new APIResponse();
        userRepository.save(user);
        System.out.print(user);
        response.setData(user.getEmail());
        response.setMessage("success");
        return response;
    }


    //REGISTER
    @PostMapping("/register")
    public Object register(User user){
        APIResponse response = new APIResponse();
        try {
            User checkRegister = userRepository.findByEmail(user.getEmail());
            if (checkRegister == null){
//                user.setPassword(encoderUtil.passwordEncoder().encode(user.getPassword()));
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

//    UPDATE
//    @PutMapping ("/userUpdate")
//    private Object update(User user, int id){
//        APIResponse response = new APIResponse();
//        try {
//            var data = userRepository.findById(id);
//            user.setId(data.getId());
//            user.setFName(data.getFName());
//            user.setEmail(data.getEmail());
//            userRepository.save(user);
//            response.setMessage("update..");
//            response.setData(data.getFName());
//
//        }catch (Exception err){
//            response.setMessage(err.toString());
//        } return response;
//    }


    }




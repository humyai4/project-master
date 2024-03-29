package com.ecp.master.controller;
import com.ecp.master.model.bean.APIResponse;
import com.ecp.master.model.service.ImageRepository;
import com.ecp.master.model.table.Image;
import com.ecp.master.util.ResourceIdGenerate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;


@CrossOrigin ("*")
@RequestMapping("/image")
@RestController
public class ImageController {
    @Autowired
    private ImageRepository imageRepository;

    @PostMapping("/save")
    public Object imageSave(Image image,@RequestParam("picture") MultipartFile file){
        APIResponse response = new APIResponse();
        String nameImage = "%s.png".formatted(new ResourceIdGenerate().resourceId());
        String part = "D:\\SCR\\projectUI\\src\\assets\\newsImg\\";
        File file1 = new File("%s%s".formatted(part,nameImage));
        try {
              file.transferTo(file1);
        } catch (IOException e){
            e.printStackTrace();
        }
        image.setImagesName(nameImage);
        var data = imageRepository.save(image);
        response.setData(data);
        response.setMessage("success...");
        return response;
    }

    @GetMapping("/img")
    public Object img(Image image){
        imageRepository.findAll();
        return  imageRepository.findAll();
    }

}

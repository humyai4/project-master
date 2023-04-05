package com.ecp.master.controller;


import com.ecp.master.model.bean.APIResponse;
import com.ecp.master.model.service.GalleryRepository;
import com.ecp.master.model.table.Brandjob;
import com.ecp.master.model.table.Gallery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/gallery")

public class GalleryController {
    @Autowired
    private GalleryRepository galleryRepository;

    @PostMapping("/createGallery")
    public Object update(Gallery gallery){
        APIResponse response = new APIResponse();
        galleryRepository.save(gallery);
        System.out.print(gallery);
        response.setData(gallery.getSubId());
        response.setData2(gallery.getGalleryId());
        response.setMessage("success");
        return  response;
    }
    @GetMapping("/bjGallery")
    private Object bj(@RequestParam Integer bjid){
        long bjId = bjid;
        return galleryRepository.findByBjId(bjId);
    }

    @GetMapping("/galleryId")
    private Object galleryId(@RequestParam Integer galleryIds){
        long galleryId = galleryIds;
        return galleryRepository.findByGalleryId(galleryId);
    }


    @GetMapping("/getPerformGallery")
    public  Object getPerform(Gallery gallery){
        galleryRepository.findAll();
        return galleryRepository.findAll();
    }

    @PostMapping("/galleryDelete")
    public  Object delete(Gallery gallery){
        APIResponse response = new APIResponse();
        galleryRepository.delete(gallery);
        response.setMessage("success");
        return response;
    }
}

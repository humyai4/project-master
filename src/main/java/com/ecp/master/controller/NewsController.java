package com.ecp.master.controller;

import com.ecp.master.model.bean.APIResponse;
import com.ecp.master.model.service.NewsRepository;
import com.ecp.master.model.table.News;
import com.ecp.master.util.ResourceIdGenerate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@CrossOrigin("*")
@RequestMapping("/news")
@RestController

public class NewsController {
    @Autowired
    private NewsRepository newsRepository;

//    @CrossOrigin
    @GetMapping("/newsList")
    private Object newsList(News news) {
        newsRepository.findAll();
        return newsRepository.findAll();
    }

    @GetMapping("/newsId")
    private Object newsId(@RequestParam Integer newsId){
        int id = newsId;
        return  newsRepository.findById(id);
    }

    @PostMapping("/newsCreate")
    private Object newsCreate(News news,@RequestParam("picture") MultipartFile file) {
        APIResponse response = new APIResponse();
        String nameImage = "%s.png".formatted(new ResourceIdGenerate().resourceId());
        String part = "D:\\SCR\\projectUI\\src\\assets\\newsImg\\";
        File file1 = new File("%s%s".formatted(part,nameImage));

        try {
            file.transferTo(file1);
            news.setNewsImg(nameImage);
            var data = newsRepository.save(news);
            newsRepository.save(news);
            response.setData(news.getNewsTitle());
            response.setData2(data);

        } catch (Exception e) {
            response.setStatus(12);
            response.setMessage("err");
        }
        return response;
    }


    @PostMapping("/newsUpdate")
    public Object update(News news){
        APIResponse response = new APIResponse();
        try {
            newsRepository.save(news);
            response.setStatus(12);
            response.setMessage("success.");
            response.setData(news.getNewsId());
        }catch (Exception e){
            e.printStackTrace();
        }return response;
    }
    @PostMapping("/newsDelete")
    public  Object delete(News news){
        APIResponse response = new APIResponse();
        newsRepository.delete(news);
        response.setMessage("success");
        return response;
    }


}

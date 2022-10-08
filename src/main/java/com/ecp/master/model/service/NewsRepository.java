package com.ecp.master.model.service;

import com.ecp.master.model.table.News;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewsRepository extends JpaRepository<News,Integer> {
    List<News> findAll();

//    News findById(int id);
}

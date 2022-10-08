package com.ecp.master.model.service;

import com.ecp.master.model.table.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface ImageRepository  extends JpaRepository<Image,Integer> {
    Image findById(int id);
}

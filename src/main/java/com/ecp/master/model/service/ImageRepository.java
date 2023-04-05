package com.ecp.master.model.service;

import com.ecp.master.model.table.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@EnableJpaRepositories
public interface ImageRepository  extends JpaRepository<Image,Integer> {
    Image findById(int id);
//    List<Image> findAll();
    List<Image>findByContentId(int contentId);

}

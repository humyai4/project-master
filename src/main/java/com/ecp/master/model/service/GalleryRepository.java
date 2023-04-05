package com.ecp.master.model.service;

import com.ecp.master.model.table.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GalleryRepository extends JpaRepository<Gallery,Integer>{
    Gallery findByGalleryId(long galleryId);

    List<Gallery> findByBjId(long bjId);
}

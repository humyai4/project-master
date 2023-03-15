package com.ecp.master.model.service;

import com.ecp.master.model.table.Brandjob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;
@EnableJpaRepositories
public interface BrandjobRepository  extends JpaRepository<Brandjob,Integer> {

    Brandjob findById(long id);
    Brandjob findByBjName(String bjName);
    Brandjob findByUserId(long userId);

//    List<Brandjob> findAllById(List<Integer>id);
}

package com.ecp.master.model.service;


import com.ecp.master.model.table.Perform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
public interface PerformRepository extends JpaRepository<Perform, Integer> {
    List<Perform>findAll();
    List<Perform>findByPerformUser(long performUser);

    Perform findByPerformId(long performId);
}

package com.ecp.master.model.service;
import com.ecp.master.model.table.Bandrating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BandratingRepository extends JpaRepository<Bandrating,Integer> {
    Bandrating findById(long id);
    List<Bandrating>findAll();

    Bandrating findByChId(long chId);

    List <Bandrating> findByBjId(long bjId);

}

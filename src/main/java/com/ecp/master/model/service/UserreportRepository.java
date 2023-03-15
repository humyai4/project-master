package com.ecp.master.model.service;

import com.ecp.master.model.table.Userreport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserreportRepository extends JpaRepository<Userreport, Integer> {
    Userreport findById(long id);
}

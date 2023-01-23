package com.ecp.master.model.service;

import com.ecp.master.model.table.Brandjob;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandjobRepository  extends JpaRepository<Brandjob,Integer> {
    Brandjob findById(int mimId);
}

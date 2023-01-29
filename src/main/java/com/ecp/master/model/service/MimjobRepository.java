package com.ecp.master.model.service;

import com.ecp.master.model.table.Brandjob;
import com.ecp.master.model.table.Mimjob;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MimjobRepository extends JpaRepository<Mimjob,Integer> {
    Brandjob findById(int jobId);

}

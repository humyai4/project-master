package com.ecp.master.model.service;

import com.ecp.master.model.table.Mim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MimRepository extends JpaRepository<Mim, Integer> {
    Mim findByMimId(long mimId);
    Mim findByMimName(String mimName);
}

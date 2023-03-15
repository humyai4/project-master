package com.ecp.master.model.service;

import com.ecp.master.model.table.Chooseband;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChooseRepository extends JpaRepository<Chooseband, Integer> {
    Chooseband findById(long id);
    List <Chooseband> findByEmpId(long empId);
}

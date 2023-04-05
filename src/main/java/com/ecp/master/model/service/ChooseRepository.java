package com.ecp.master.model.service;

import com.ecp.master.model.table.Chooseband;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ChooseRepository extends JpaRepository<Chooseband, Integer> {
    Chooseband findById(long id);
    void deleteByBjId(long bjId);
    List <Chooseband> findByEmpId(long empId);
    List <Chooseband> findByBjId(long bjId);
    List <Chooseband> findByUserId(long userId);
    List <Chooseband> findByUserIdAndStatus(long userId,int status);
    List <Chooseband> findByEmpIdAndStatus(long empId,int status);
    List <Chooseband> findByStatus(int status);


    Optional <Chooseband> findByBjIdAndEmpId(long bjId, long empId);

}

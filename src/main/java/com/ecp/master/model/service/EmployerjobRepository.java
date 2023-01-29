package com.ecp.master.model.service;
import com.ecp.master.model.table.Employerjob;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerjobRepository extends JpaRepository<Employerjob,Integer> {
    Employerjob findById(long id);
    Employerjob findByEjName(String ejName);
}

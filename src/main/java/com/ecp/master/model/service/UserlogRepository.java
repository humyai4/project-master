package com.ecp.master.model.service;

import com.ecp.master.model.table.Userlog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserlogRepository extends JpaRepository<Userlog , Integer> {
    UserlogRepository findByUlogId(long ulogId);
}

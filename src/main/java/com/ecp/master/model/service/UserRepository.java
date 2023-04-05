package com.ecp.master.model.service;

import com.ecp.master.model.table.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<User,Integer> {
    User findById(int id);

    List<User> findByRole(long role);
    User findByEmail(String email);
    User findByEmailAndPassword(String email, String password);

}

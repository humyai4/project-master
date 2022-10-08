package com.ecp.master.model.service;

import com.ecp.master.model.table.Role;
import com.ecp.master.model.role.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}

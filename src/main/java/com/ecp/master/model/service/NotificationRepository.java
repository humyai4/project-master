package com.ecp.master.model.service;

import java.util.List;
import com.ecp.master.model.table.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
    List<Notification> findAll();
}

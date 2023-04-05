package com.ecp.master.model.service;

import java.util.List;
import com.ecp.master.model.table.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface NotificationRepository extends JpaRepository<Notification, Integer> {
    List<Notification> findAll();

    Notification findByNotiId(long notiId);
    List <Notification> findByUserIdTo(int userIdTo);
//    List<Notification> findDistinctByUserIdTo(List<String> userIdTo);
    List  <Notification> findByUserIdToAndReadstatus(int userIdTo,String readstatus);
}

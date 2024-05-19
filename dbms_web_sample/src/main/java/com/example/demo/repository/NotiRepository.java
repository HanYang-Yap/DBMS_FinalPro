package com.example.demo.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface NotiRepository extends JpaRepository<Notification, Long> {
    List<Notification> findAll();
    List<Notification> findByNotiId(Long noti_Id);
}

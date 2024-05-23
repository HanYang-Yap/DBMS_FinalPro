package com.example.demo.service;

import com.example.demo.model.Notification;
import com.example.demo.repository.NotiRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotiService {

    private final NotiRepository notiRepository;

    public NotiService(NotiRepository notiRepository) {
        this.notiRepository = notiRepository;
    }

    public List<Notification> getNotis() {
        return notiRepository.findAll();
    }

    public List<Notification> findByNotiId(Long noti_Id) {
        return notiRepository.findByNotiId(noti_Id);
    }

    public Notification getNotiById(Long id) {
        return notiRepository.findById(id).orElseThrow(() -> new RuntimeException("Notification not found with id " + id));
    }

    public Notification createNoti(Notification noti) {
        return notiRepository.save(noti);
    }

    public Notification updateNoti(Notification noti) {
        return notiRepository.save(noti);
    }

    public void deleteNoti(Long id) {
        notiRepository.deleteById(id);
    }
}
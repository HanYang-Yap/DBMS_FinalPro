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

    public List<Notification> getUsers() {
        return notiRepository.findAll();
    }

    public List<Notification> findByNotiId(Long noti_Id) {
        return notiRepository.findByNotiId(noti_Id);
    }

    public Notification createUser(Notification user) {
        return notiRepository.save(user);
    }

    public Notification updateUser(Notification user) {
        return notiRepository.save(user);
    }

    public void deleteVenue(Long id) {
        notiRepository.deleteById(id);
    }
}
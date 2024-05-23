package com.example.demo.controller;

import com.example.demo.model.Notification;
import com.example.demo.model.Product;
import com.example.demo.model.Venue;
import com.example.demo.service.NotiService;
import com.example.demo.service.VenueService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotiController {
    @Autowired
    private NotiService notiService;

    @Autowired
    private VenueService venueService;

    @GetMapping
    public List<Notification> listAllNoti(@RequestParam(required = false, name = "notiId") Long notiId) {
        if (notiId != null) {
            return notiService.findByNotiId(notiId);
        } else {
            return notiService.getNotis();
        }
    }

    @GetMapping("/{id}")
    public Notification getNotiById(@PathVariable("id") Long id) {
        return notiService. getNotiById(id);
    }

    @PostMapping
    public Notification createNoti(@RequestBody Notification noti) {
        return notiService.createNoti(noti);
    }

    @PutMapping("/{id}")
    public Notification updateNoti(@RequestBody Notification noti) {
        return notiService.updateNoti(noti);
    }

    @DeleteMapping("/{id}")
    public void deleteNoti(@PathVariable("id") Long id) {
        notiService.deleteNoti(id);
    }
}
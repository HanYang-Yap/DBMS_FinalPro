package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Noti_id")
    private Long Noti_id;

    @ManyToOne
    @JoinColumn(name = "Admin_id", referencedColumnName = "Admin_id", nullable = false)
    private Admin admin_id;

    @ManyToOne
    @JoinColumn(name = "Venue_id", referencedColumnName = "Venue_id", nullable = false)
    private Venue venue_id;

    @Column(name = "Sent_date", nullable = false)
    private LocalDate sent_date;

    @Column(name = "Context", nullable = false, length = 100)
    private String context;

    @Column(name = "Pin", nullable = false)
    private boolean pin;

    public Notification() {
    }

    public Notification(Long Noti_id, Admin admin_id, Venue venue_id, LocalDate sent_date, String context, boolean pin) {
        this.Noti_id = Noti_id;
        this.admin_id = admin_id;
        this.venue_id = venue_id;
        this.sent_date = sent_date;
        this.context = context;
        this.pin = pin;
    }

    public Long getNoti_id() {
        return Noti_id;
    }

    public void setNoti_id(Long Noti_id) {
        this.Noti_id = Noti_id;
    }

    public Admin getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Admin admin_id) {
        this.admin_id = admin_id;
    }

    public Venue getVenue_id() {
        return venue_id;
    }

    public void setVenue_id(Venue venue_id) {
        this.venue_id = venue_id;
    }

    public LocalDate getSent_date() {
        return sent_date;
    }

    public void setSent_date(LocalDate sent_date) {
        this.sent_date = sent_date;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public boolean isPin() {
        return pin;
    }

    public void setPin(boolean pin) {
        this.pin = pin;
    }
}


package com.example.demo.model;
import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "venue")
public class Venue {
    @Id
    @Column(name = "Venue_id")
    private Long Venue_id;

    @Column(name = "Venue_name", nullable = false, length = 10)
    private String Venue_name;

    @Column(name = "Fee_type", nullable = false, length = 10)
    private String Fee_type;

    @Column(name = "Fee_amount", nullable = false)
    private int Fee_amount;

    @Column(name = "RTQuantity", nullable = false)
    private int RTQuantity;

    @Column(name = "AQuantity", nullable = false)
    private int AQuantity;

    @ManyToOne
    @JoinColumn(name = "Admin_id", referencedColumnName = "Admin_id", nullable = false)
    private Admin admin_id;

    public Venue() {
    }

    public Venue(Long Venue_id, String Venue_name, String Fee_type, int Fee_amount, int RTQuantity, int AQuantity,
            Admin admin_id) {
        this.Venue_id = Venue_id;
        this.Venue_name = Venue_name;
        this.Fee_type = Fee_type;
        this.Fee_amount = Fee_amount;
        this.RTQuantity = RTQuantity;
        this.AQuantity = AQuantity;
        this.admin_id = admin_id;
    }

    public Long getVenue_id() {
        return Venue_id;
    }

    public void setVenue_id(Long Venue_id) {
        this.Venue_id = Venue_id;
    }

    public String getVenue_name() {
        return Venue_name;
    }

    public void setVenue_name(String Venue_name) {
        this.Venue_name = Venue_name;
    }

    public String getFee_type() {
        return Fee_type;
    }

    public void setFee_type(String Fee_type) {
        this.Fee_type = Fee_type;
    }

    public int getFee_amount() {
        return Fee_amount;
    }

    public void setFee_amount(int Fee_amount) {
        this.Fee_amount = Fee_amount;
    }

    public int getRTQuantity() {
        return RTQuantity;
    }

    public void setRTQuantity(int RTQuantity) {
        this.RTQuantity = RTQuantity;
    }

    public int getAQuantity() {
        return AQuantity;
    }

    public void setAQuantity(int AQuantity) {
        this.AQuantity = AQuantity;
    }

    public Admin getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Admin admin_id) {
        this.admin_id = admin_id;
    }
}

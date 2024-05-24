package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "admin")
public class Admin{

    @Id
    @Column(name = "Adm_id", nullable = false, unique = true)
    private Long Adm_id;

    @Column(name = "adm_name",nullable = false, length = 15)
    private String Adm_name;

    @Column(name = "Authority",nullable = false, length = 10)
    private String authority;

    // Constructors
    public Admin() {
    }

    public Admin(Long Adm_id, String Adm_name, String authority) {
        this.Adm_id = Adm_id;
        this.Adm_name = Adm_name;
        this.authority = authority;
    }

    // Getters and Setters
    public Long getAdm_id() {
        return Adm_id;
    }

    public void setAdm_id(Long Adm_id) {
        this.Adm_id = Adm_id;
    }

    public String getAdm_name() {
        return Adm_name;
    }

    public void setAdm_name(String Adm_name) {
        this.Adm_name = Adm_name;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}

package com.helloit.householdtracker.ux.entities;

import javax.persistence.*;

@Entity
@Table(name = "Account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String password;


    private Integer emplNumber;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPasswordassword(final String password) {
        this.password = password;
    }
}
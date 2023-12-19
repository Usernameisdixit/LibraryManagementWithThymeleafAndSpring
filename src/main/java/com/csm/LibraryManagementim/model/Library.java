package com.csm.LibraryManagementim.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lib_name;
    private String  subscription_type;

    private Double subscription_fee;


    public List<User> getUsr() {
        return usr;
    }

    public void setUsr(List<User> usr) {
        this.usr = usr;
    }

    @OneToMany(mappedBy = "library")
    private List<User> usr;

    public Library()
    {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLib_name() {
        return lib_name;
    }

    public void setLib_name(String lib_name) {
        this.lib_name = lib_name;
    }

    public String getSubscription_type() {
        return subscription_type;
    }

    public void setSubscription_type(String subscription_type) {
        this.subscription_type = subscription_type;
    }

    public double getSubscription_fee() {
        return subscription_fee;
    }

    public void setSubscription_fee(double subscription_fee) {
        this.subscription_fee = subscription_fee;
    }

    @Override
    public String toString() {
        return "Library{" +
                "id=" + id +
                ", lib_name='" + lib_name + '\'' +
                ", subscription_type='" + subscription_type + '\'' +
                ", subscription_fee=" + subscription_fee +
                ", usr=" + usr +
                '}';
    }
}

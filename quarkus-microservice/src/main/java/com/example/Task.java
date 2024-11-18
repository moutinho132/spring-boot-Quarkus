package com.example;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Task extends PanacheEntity {
    public String title;
    public String description;
    public boolean completed;
}
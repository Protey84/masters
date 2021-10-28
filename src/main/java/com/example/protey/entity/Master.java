package com.example.protey.entity;

import javax.persistence.*;

@Entity
@Table(name = "masters")
public class Master {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    private String name;

    public Master() {
    }

    public Master(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Master(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

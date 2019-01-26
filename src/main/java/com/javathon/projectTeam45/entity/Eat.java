package com.javathon.projectTeam45.entity;

import javax.persistence.*;

@Entity
public class Eat {

    public Eat() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "eat_id")
    private Long id;

    @Column(name = "eat_name")
    private String name;
}

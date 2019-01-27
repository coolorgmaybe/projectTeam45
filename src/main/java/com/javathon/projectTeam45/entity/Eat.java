package com.javathon.projectTeam45.entity;

import javax.persistence.*;

@Entity
@Table(name = "eat")
public class Eat {

    public Eat() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
}

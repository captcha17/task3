package com.epam.task3.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Agent {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;
}

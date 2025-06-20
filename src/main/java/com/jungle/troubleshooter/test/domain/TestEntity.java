package com.jungle.troubleshooter.test.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "test")
public class TestEntity {

    @Id
    private Long id;

    private String message;

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}

package com.informatics.practice.app.repository;

import com.fasterxml.jackson.annotation.JsonProperty;


import java.io.Serial;
import java.io.Serializable;

public class PersonDto implements Serializable {
    @Serial
    private  static final long SerialVersionUID=1L;
    private String firstName;
    private String lastName;

    private int age;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

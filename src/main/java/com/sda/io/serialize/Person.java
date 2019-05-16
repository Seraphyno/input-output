package com.sda.io.serialize;

import java.io.Serializable;

class Person implements Serializable {

    private String firstName;
    private String lastName;

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

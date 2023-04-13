package com.protobuf;

import com.models.Person;

public class DefaultValueDemo {

    public static void main(String[] args) {

        Person person = Person.newBuilder().build();
        System.out.println("city = " + person.getAddress().getCity());  // no nulls in protobuf
        System.out.println(person.hasAddress());    // methods to tell you if an object has fields
    }
}

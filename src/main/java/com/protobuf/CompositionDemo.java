package com.protobuf;

import com.google.protobuf.Int32Value;
import com.models.common.Address;
import com.models.common.Car;
import com.models.Person;

import java.util.ArrayList;

public class CompositionDemo {

    public static void main(String[] args) {
        Address address = Address.newBuilder()
                .setPostbox(10)
                .setStreet("main street")
                .setCity("Brooklyn")
                .build();
        Car accord = Car.newBuilder()
                .setMake("Honda")
                .setModel("Accord")
                .setYear(1990)
                .build();
        Car civic = Car.newBuilder()
                .setMake("Honda")
                .setModel("Civic")
                .setYear(1990)
                .build();
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(accord);
        cars.add(civic);

        Person sam = Person.newBuilder()
                .setName("sam")
                .setAge(Int32Value.newBuilder().setValue(10).build())
                .setAddress(address)
                .addAllCar(cars)
                .build();
        System.out.println(sam.hasAge());
    }
}

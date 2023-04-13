package com.protobuf;

import com.models.common.BodyStyle;
import com.models.common.Car;
import com.models.Dealer;

public class MapDemo {

    public static void main(String[] args) {
        Car accord = Car.newBuilder()
                .setMake("Honda")
                .setModel("Accord")
                .setBodyStyle(BodyStyle.COUPE)
                .setYear(1990)
                .build();
        Car civic = Car.newBuilder()
                .setMake("Honda")
                .setModel("Civic")
                .setBodyStyle(BodyStyle.SUV)
                .setYear(1990)
                .build();

        Dealer dealer = Dealer.newBuilder()
                .putModel(2020,accord)
                .putModel(2005,civic)
                .build();
        System.out.println(dealer.getModelOrThrow(2005).getBodyStyle());
        //System.out.println(dealer.getModelOrDefault(2004,accord));
        //System.out.println(dealer.getModelMap());
    }
}

package com.protobuf;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.Int32Value;
import com.google.protobuf.InvalidProtocolBufferException;
import com.json.JPerson;
import com.models.Person;

public class PerformanceTest {
    public static void main(String[] args) {

        JPerson person = new JPerson();
        person.setAge(10);
        person.setName("sam");
        ObjectMapper mapper = new ObjectMapper();

        Runnable runnable1 = () -> {
            try {
                byte[] bytes = mapper.writeValueAsBytes(person);
                System.out.println(bytes.length);
                JPerson person2 = mapper.readValue(bytes, JPerson.class);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };

        Person sam = Person.newBuilder()
                .setAge(Int32Value.newBuilder().setValue(10).build())
                .setName("sam")
                .build();

        Runnable runnable2 = () -> {
            try {
                byte[] bytes = sam.toByteArray();
                System.out.println(bytes.length);
                Person sam1 = Person.parseFrom(bytes);
            } catch (InvalidProtocolBufferException e) {
                throw new RuntimeException(e);
            }
        };
        runPerformanceTest(runnable1,"JSON");
        runPerformanceTest(runnable2,"PROTOBUF");
    }

    private static void runPerformanceTest(Runnable runnable,
                                           String method) {
        long time1 = System.currentTimeMillis();
        for(int i = 0;i<1; i++) {
            runnable.run();
        }
        long time2 = System.currentTimeMillis();
        System.out.println(method + " total time = " + (time2-time1)
                + " milliseconds");
    }
}

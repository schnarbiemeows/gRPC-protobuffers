package com.protobuf;

import com.models.common.Credentials;
import com.models.common.EmailCredentials;
import com.models.common.PhoneOTP;

public class OneOfDemo {

    public static void main(String[] args) {
        EmailCredentials emailCredentials = EmailCredentials.newBuilder()
                .setEmail("myemail@email.com")
                .setPassword("nunja")
                .build();

        PhoneOTP otp = PhoneOTP.newBuilder()
                .setCode(123)
                .setNumber(456)
                .build();

        Credentials credentials = Credentials.newBuilder()
                .setEmailMode(emailCredentials)
                .build();
        login(credentials);
        credentials = Credentials.newBuilder()
                .setPhoneMode(otp)
                .build();
        login(credentials);
    }

    private static void login(Credentials credentials) {
        switch (credentials.getModeCase()) {
            case EMAILMODE:
                System.out.println(credentials.getEmailMode());
                break;
            case PHONEMODE:
                System.out.println(credentials.getPhoneMode());
                break;
        }

    }
}

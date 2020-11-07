package com.ppwa.wa2fa.otp.application;

import com.ppwa.wa2fa.otp.domain.OtpMessage;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class OtpMessageFactory {

    public OtpMessage build() {

        String uuid = UUID.randomUUID().toString();
        Integer otpCode = 428478;
        String countryCode = "57";
        String phoneNumber = "3043775898";
        return new OtpMessage(uuid, otpCode, countryCode, phoneNumber);
    }
}

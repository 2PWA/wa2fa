package com.ppwa.wa2fa.otp.domain;

import com.ppwa.wa2fa.otp.application.CreateOtpMessageCommand;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class OtpMessageFactory {

    private final OtpGeneratorService otpGeneratorService;

    OtpMessageFactory(OtpGeneratorService otpGeneratorService) {
        this.otpGeneratorService = otpGeneratorService;
    }

    public OtpMessage build(CreateOtpMessageCommand createOtpMessageCommand) {

        String uuid = UUID.randomUUID().toString();
        String otpCode = otpGeneratorService.generate();
        String countryCode = createOtpMessageCommand.getCountryCode();
        String phoneNumber = createOtpMessageCommand.getPhoneNumber();
        return new OtpMessage(uuid, otpCode, countryCode, phoneNumber);
    }
}

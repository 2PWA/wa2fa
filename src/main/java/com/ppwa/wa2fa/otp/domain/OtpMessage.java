package com.ppwa.wa2fa.otp.domain;

import org.springframework.data.mongodb.core.mapping.MongoId;

public class OtpMessage {

    @MongoId
    private final String uuid;
    private final Integer code;
    private final String countryCode;
    private final String phoneNumber;

    public OtpMessage(String uuid, Integer code, String countryCode, String phoneNumber) {
        this.uuid = uuid;
        this.code = code;
        this.countryCode = countryCode;
        this.phoneNumber = phoneNumber;
    }

    public String getUuid() {
        return this.uuid;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }
}

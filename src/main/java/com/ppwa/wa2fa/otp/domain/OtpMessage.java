package com.ppwa.wa2fa.otp.domain;

import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;

public class OtpMessage {

    @MongoId
    private final String uuid;
    private final String code;
    private final String countryCode;
    private final String phoneNumber;
    private final LocalDateTime dateCreated;

    public OtpMessage(String uuid, String code, String countryCode, String phoneNumber, LocalDateTime dateCreated) {
        this.uuid = uuid;
        this.code = code;
        this.countryCode = countryCode;
        this.phoneNumber = phoneNumber;
        this.dateCreated = dateCreated;
    }

    public String getUuid() {
        return uuid;
    }

    public String getCode() {
        return code;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

}

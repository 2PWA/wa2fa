package com.ppwa.wa2fa.otp.application;

public class CreateOtpMessageCommand {

    private String apiKey;
    private final String countryCode;
    private final String phoneNumber;

    public CreateOtpMessageCommand(String countryCode, String phoneNumber) {
        this.countryCode = countryCode;
        this.phoneNumber = phoneNumber;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

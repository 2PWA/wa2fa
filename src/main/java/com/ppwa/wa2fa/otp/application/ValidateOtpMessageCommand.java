package com.ppwa.wa2fa.otp.application;

public class ValidateOtpMessageCommand {

    private final String uuid;
    private final String apiKey;
    private final String code;

    public ValidateOtpMessageCommand(String uuid, String apiKey, String code) {
        this.uuid = uuid;
        this.apiKey = apiKey;
        this.code = code;
    }

    public String getUuid() {
        return uuid;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getCode() {
        return code;
    }
}

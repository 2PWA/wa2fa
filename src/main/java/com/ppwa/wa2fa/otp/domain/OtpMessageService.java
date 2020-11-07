package com.ppwa.wa2fa.otp.domain;

import reactor.core.publisher.Mono;

public interface OtpMessageService {
    Mono<String> sendCode(OtpMessage otpMessage);
}

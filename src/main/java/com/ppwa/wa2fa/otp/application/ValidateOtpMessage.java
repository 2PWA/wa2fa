package com.ppwa.wa2fa.otp.application;

import com.ppwa.wa2fa.otp.domain.OtpMessage;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ValidateOtpMessage {

    private final OtpRepository otpRepository;

    ValidateOtpMessage(OtpRepository otpRepository) {
        this.otpRepository = otpRepository;
    }

    public Mono<String> execute(ValidateOtpMessageCommand validateOtpMessageCommand) {

        return this.otpRepository.findById(validateOtpMessageCommand.getUuid())
                .flatMap(otpMessage -> this.validateOtpCode(otpMessage, validateOtpMessageCommand));
    }

    private Mono<String> validateOtpCode(OtpMessage otpMessage, ValidateOtpMessageCommand validateOtpMessageCommand) {
        return null;
    }
}

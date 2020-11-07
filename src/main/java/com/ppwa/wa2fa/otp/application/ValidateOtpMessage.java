package com.ppwa.wa2fa.otp.application;

import com.ppwa.wa2fa.otp.domain.OtpMessage;
import com.ppwa.wa2fa.otp.infrastructure.CodeNotValidException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import static reactor.core.publisher.Mono.error;

@Service
public class ValidateOtpMessage {

    private final OtpRepository otpRepository;

    ValidateOtpMessage(OtpRepository otpRepository) {
        this.otpRepository = otpRepository;
    }

    public Mono<Void> execute(ValidateOtpMessageCommand validateOtpMessageCommand) {

        return otpRepository.findById(validateOtpMessageCommand.getUuid())
                            .switchIfEmpty(error(CodeNotValidException::new))
                            .flatMap(otpMessage -> validateOtpCode(otpMessage, validateOtpMessageCommand))
                            .flatMap(otpMessage -> otpRepository.deleteById(validateOtpMessageCommand.getUuid()))
                            .then();
    }

    private Mono<OtpMessage> validateOtpCode(OtpMessage otpMessage, ValidateOtpMessageCommand validateOtpMessageCommand) {
        if (!otpMessage.getCode().equals(validateOtpMessageCommand.getCode())) throw new CodeNotValidException();
        return  Mono.just(otpMessage);
    }
}

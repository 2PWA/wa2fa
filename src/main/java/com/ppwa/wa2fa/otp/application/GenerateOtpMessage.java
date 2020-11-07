package com.ppwa.wa2fa.otp.application;

import com.ppwa.wa2fa.otp.domain.OtpMessage;
import com.ppwa.wa2fa.otp.domain.OtpMessageFactory;
import com.ppwa.wa2fa.otp.infrastructure.OtpWhatsAppService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class GenerateOtpMessage {

    private final OtpRepository otpRepository;
    private final OtpWhatsAppService otpService;
    private final OtpMessageFactory otpMessageFactory;

    GenerateOtpMessage(OtpRepository otpRepository, OtpWhatsAppService otpService, OtpMessageFactory otpMessageFactory) {
        this.otpRepository = otpRepository;
        this.otpService = otpService;
        this.otpMessageFactory = otpMessageFactory;
    }

    public Mono<String> execute(CreateOtpMessageCommand createOtpMessageCommand) {

        OtpMessage otpMessage = this.otpMessageFactory.build(createOtpMessageCommand);
        return otpRepository.save(otpMessage)
                            .flatMap(code -> otpService.sendCode(otpMessage));
    }
}

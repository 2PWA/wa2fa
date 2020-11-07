package com.ppwa.wa2fa.otp.infrastructure;

import com.ppwa.wa2fa.otp.application.GenerateOtpMessage;
import com.ppwa.wa2fa.otp.application.CreateOtpMessageCommand;
import com.ppwa.wa2fa.otp.application.ValidateOtpMessage;
import com.ppwa.wa2fa.otp.application.ValidateOtpMessageCommand;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
public final class OtpController {

    private final GenerateOtpMessage generateOtpMessage;
    private final ValidateOtpMessage validateOtpMessage;

    OtpController(GenerateOtpMessage generateOtpMessage, ValidateOtpMessage validateOtpMessage) {
        this.generateOtpMessage = generateOtpMessage;
        this.validateOtpMessage = validateOtpMessage;
    }

    @PostMapping("/otp")
    public Mono<String> generate(@RequestBody CreateOtpMessageCommand createOtpMessageCommand,
                                 @RequestHeader("x-api-key") String apiKey) {
        createOtpMessageCommand.setApiKey(apiKey);
        return this.generateOtpMessage.execute(createOtpMessageCommand);
    }

    @PostMapping("/otp/{uuid}")
    public Mono<String> validate(@PathVariable String uuid,
                                 @RequestHeader("x-api-key") String apiKey,
                                 @RequestHeader("x-wa2fa-otp") String otpCode) {
        ValidateOtpMessageCommand validateOtpMessageCommand = new ValidateOtpMessageCommand(uuid, apiKey, otpCode);

        return this.validateOtpMessage.execute(validateOtpMessageCommand);
    }
}

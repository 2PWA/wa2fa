package com.ppwa.wa2fa.otp.infrastructure;

import com.ppwa.wa2fa.otp.domain.OtpMessage;
import com.ppwa.wa2fa.otp.domain.OtpMessageService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public final class OtpWhatsAppService implements OtpMessageService {

    private static final String ACCOUNT_SID = "ACa6cbc88514902675d85f202f9d639473";
    private static final String AUTH_TOKEN = "07d68d819b1ad50dfa42ee44847efb87";
    public Mono<String> sendCode(OtpMessage otpMessage) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("whatsapp:+" + otpMessage.getCountryCode() + otpMessage.getPhoneNumber()),
                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
                "Your verification code is " + otpMessage.getCode())
                .create();

        return Mono.just(otpMessage.getUuid());
    }
}

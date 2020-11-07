package com.ppwa.wa2fa.otp.application;

import com.ppwa.wa2fa.otp.domain.OtpMessage;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface OtpRepository  extends ReactiveMongoRepository<OtpMessage, String> {

}

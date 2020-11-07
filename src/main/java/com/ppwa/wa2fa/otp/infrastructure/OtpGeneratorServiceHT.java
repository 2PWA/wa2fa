package com.ppwa.wa2fa.otp.infrastructure;

import com.eatthepath.otp.TimeBasedOneTimePasswordGenerator;
import com.ppwa.wa2fa.otp.domain.OtpGeneratorService;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;

@Service
public class OtpGeneratorServiceHT implements OtpGeneratorService {

    @Override
    public String generate() {
        String otpCode = null;
        try {
            final TimeBasedOneTimePasswordGenerator totp = new TimeBasedOneTimePasswordGenerator();
            final KeyGenerator keyGenerator = KeyGenerator.getInstance(totp.getAlgorithm());

            // Key length should match the length of the HMAC output (160 bits for SHA-1, 256 bits
            // for SHA-256, and 512 bits for SHA-512).
            keyGenerator.init(256);

            final Key key = keyGenerator.generateKey();
            otpCode = String.format("%06d", totp.generateOneTimePassword(key, Instant.now()));
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
        }
        return otpCode;
    }
}

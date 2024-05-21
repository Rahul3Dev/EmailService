package com.nobroker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import static com.nobroker.service.EmailVerificationService.emailOtpMapping;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    private final UserService userService;

    @Autowired
    public EmailService(JavaMailSender javaMailSender, UserService userService) {
        this.javaMailSender = javaMailSender;
        this.userService = userService;
    }
//we put this method presentably/separately because we want otp for login and email-verification for usability
    public String generateOtp() {
        return String.format("%06d", new java.util.Random().nextInt(1000000));
    }

    public Map<String, String> sendOtpEmail(String email) {
        String otp = generateOtp();
// save the otp in a HasMap for as a key value pair for a later verification
        emailOtpMapping.put(email, otp);

        //  send otp to the users email
        sendEmail(email, "OTP for Email Verification", "Your OTP is: "+otp);

        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "OTP sent successfully");
        return response;
    }

    private void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("your.gmail@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }

}

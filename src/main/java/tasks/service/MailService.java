package tasks.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
@ConditionalOnProperty(prefix = "spring.mail", name = "host")
public class MailService {
    private final JavaMailSender mailSender;

    public void sendEmail(String to, String subject, String text) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);
            message.setFrom("wlsejrdyd@gmail.com");
            mailSender.send(message);
            log.info("✅ 이메일 전송 성공 → to: {}", to);
        } catch (Exception e) {
            log.error("❌ 이메일 전송 실패: {}", e.getMessage(), e);
        }
    }
}

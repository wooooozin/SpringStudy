package com.woozi.lms.component;

import jakarta.mail.internet.MimeMessage;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class MailComponents {

  private final JavaMailSender javaMailSender;

  public boolean sendMail(String email, String subject, String text) {

    boolean result = false;
    MimeMessagePreparator msg = new MimeMessagePreparator() {
      @Override
      public void prepare(MimeMessage mimeMessage) throws Exception {
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        mimeMessageHelper.setTo(email);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(text, true);

      }
    };

    try {
      javaMailSender.send(msg);
      result = true;
    } catch (Exception e) {
      log.error(e.toString());
    }

    return result;
  }

}

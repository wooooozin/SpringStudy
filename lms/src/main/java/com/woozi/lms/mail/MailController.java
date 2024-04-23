package com.woozi.lms.mail;

import com.woozi.lms.component.MailComponents;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class MailController {
  private final MailComponents mailComponents;

  @GetMapping("/api/mail-send")
  public void mailSender(@RequestParam String email) {
    String subject = "인증메일";
    String text = "<p>인증메일</p><p>123</p>";
    mailComponents.sendMail(email, subject, text);

  }

}

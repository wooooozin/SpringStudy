package com.woozi.lms.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

  private final MemberService memberService;

  @GetMapping("/register")
  public String moveToMemberRegisterPage() {
    return "member/register";
  }

  @PostMapping("/register")
  public ResponseEntity<String> registerMember(
      @RequestBody MemberRequestDto member
  ) {
    try {
      log.info("URL :: /memeber/register :: INPUT {}", member.getEmail());
      boolean isRegister = memberService.registerMember(member);
      if ( isRegister ) {
        return ResponseEntity.ok("회원등록 완료");
      }
      return ResponseEntity.badRequest().body("회원가입 실패");
    } catch (Exception e) {
      log.error(e.toString());
      return ResponseEntity.internalServerError().body(e.getMessage());
    }
  }

  @GetMapping("/email-auth")
  public String emailAuth(
      Model model,
      @RequestParam String id
  ) {
    log.info("URL :: /memeber/email-auth :: INPUT {}", id);
    boolean isAuth = memberService.emailAuthByUUID(id);
    model.addAttribute("result", isAuth);
    return "member/email_auth";
  }

  @GetMapping("/info")
  public String memberInfo() {
    return "member/info";
  }

}

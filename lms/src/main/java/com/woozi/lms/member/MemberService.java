package com.woozi.lms.member;

import com.woozi.lms.component.MailComponents;
import java.time.LocalDateTime;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

  private final MemberRepository memberRepository;
  private final MailComponents mailComponents;

  @Transactional
  public boolean registerMember(MemberRequestDto member) {
    Optional<Member> findMember = memberRepository.findMemberByEmail(member.getEmail());
    if ( findMember.isPresent() ) {
      throw new RuntimeException("이미 가입되어있는 이메일입니다.");
    }

    Member savbedMember = Member.from(member);
    try {
      memberRepository.save(savbedMember);

      String email = savbedMember.getEmail();
      String sub = "회원 가입 인증메일";
      String uuid = savbedMember.getEmailAuthKey();
      String text = "<p>이메일 인증을 확인해주세요.</p>"
          + "<div><a href='http://localhost:8080/member/email-auth?id=" + uuid + "'> 가입완료</a></div>";
      mailComponents.sendMail(email, sub, text);
      return true;
    } catch (DataIntegrityViolationException e) {
      log.error("가입 시도 중 데이터 무결성 위반: ", e);
      throw e;
    }
  }

  public boolean emailAuthByUUID(String id) {
    Optional<Member> optionalMember = memberRepository.findByEmailAuthKey(id);
    if ( optionalMember.isEmpty()) {
      return false;
    }
    Member member = optionalMember.get();
    member.setEmailAuthYn(true);
    member.setEmailAuthDt(LocalDateTime.now());
    memberRepository.save(member);
    return true;
  }
}

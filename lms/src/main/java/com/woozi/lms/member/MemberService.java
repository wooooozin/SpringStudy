package com.woozi.lms.member;

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

  @Transactional
  public boolean registerMember(MemberRequestDto member) {
    Optional<Member> findMember = memberRepository.findMemberByEmail(member.getEmail());
    if ( findMember.isPresent() ) {
      throw new RuntimeException("이미 가입되어있는 이메일입니다.");
    }

    Member savbedMember = Member.from(member);
    try {
      memberRepository.save(savbedMember);
      return true;
    } catch (DataIntegrityViolationException e) {
      log.error("가입 시도 중 데이터 무결성 위반: ", e);
      throw e;
    }
  }
}

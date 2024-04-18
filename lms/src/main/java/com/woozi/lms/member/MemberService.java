package com.woozi.lms.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

  private final MemberRepository memberRepository;

  public void registerMember(MemberRequestDto member) {
    Member savedMember = Member.from(member);
    memberRepository.save(savedMember);
  }
}

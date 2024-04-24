package com.woozi.lms.member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Setter
@Entity
public class Member {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @NotNull
  private Long memberSeq;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  private String memberName;

  @Column(nullable = false)
  private String password;

  private String phone;

  private LocalDateTime regDT;

  private boolean emailAuthYn;

  private String emailAuthKey;

  public static Member from(MemberRequestDto member) {
    Member registerMember = new Member();
    registerMember.setMemberName(member.getUserName());
    registerMember.setEmail(member.getEmail());
    registerMember.setPassword(member.getPassword());
    registerMember.setPhone(member.getPhone());
    registerMember.setRegDT(LocalDateTime.now());
    registerMember.setEmailAuthYn(false);
    registerMember.setEmailAuthKey(UUID.randomUUID().toString());
    return registerMember;
  }
}

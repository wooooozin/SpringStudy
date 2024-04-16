package com.woozi.lms.member;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberRequestDto {

  private String email;
  private String userName;
  private String password;
  private String phone;

}

package com.hello.hellospring.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.hello.hellospring.domain.Member;
import com.hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void joinTest() {
        // given
        Member member1 = new Member();
        member1.setName("잔망루피");

        // when
        Long saveId = memberService.join(member1);

        // then
        Member result = memberService.findOne(saveId).get();
        assertThat(member1.getName().equals(result.getName()));

    }

    @Test
    void 중복_히원_멤버() {
        //given
        Member member1 = new Member();
        member1.setName("잔망루피");

        Member member2 = new Member();
        member2.setName("잔망루피");

        // when

        memberService.join(member1);
        assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        // then
    }

    @Test
    void findMemberAllTest() {
    }

    @Test
    void findOneTest() {
    }
}
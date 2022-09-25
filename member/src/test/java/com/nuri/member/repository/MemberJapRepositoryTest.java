package com.nuri.member.repository;

import static org.assertj.core.api.Assertions.assertThat;

import javax.transaction.Transactional;

import com.nuri.member.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
class MemberJapRepositoryTest {

    @Autowired
    MemberJapRepository memberJapRepository;

    @Test
    void testMember() {
        Member member = new Member("memberA");
        Member savedMember = memberJapRepository.save(member);

        Member findMember = memberJapRepository.find(savedMember.getId());

        assertThat(findMember.getId()).isEqualTo(savedMember.getId());
        assertThat(findMember.getName()).isEqualTo(savedMember.getName());
        assertThat(findMember).isEqualTo(savedMember);

    }
}
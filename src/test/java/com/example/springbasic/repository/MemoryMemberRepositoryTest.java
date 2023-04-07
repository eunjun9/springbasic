package com.example.springbasic.repository;

import com.example.springbasic.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach // 테스트 함수가 하나 끝날때마다 실행
    public void afterEach() {
        repository.clearStore(); // 하나의 테스트가 끝날 때마다 저장소를 지워줘야 전체 테스트 돌렸을 때 에러가 나지 않음 (누적된 데이터 삭제)
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");
        
        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        // System.out.println("result = " + (result == member)); // soutv 입력
        // 실제값 = 기대값 검증
        assertThat(result).isEqualTo(member); // Alt + Enter -> Add on-demand ~ -> 클래스 전체(*) import하고 함수명 바로 사용 // ctrl + q -> 함수 상세설명
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }

}
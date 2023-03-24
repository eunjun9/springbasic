package com.example.springbasic.repository;

import com.example.springbasic.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{ // Alt + Enter -> implements method
    // Ctrl + Shift + T -> Test Class 생성

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // null일 경우 클라이언트에서 처리
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); // Member 리스트 반환
    }

    public void clearStore() {
        store.clear(); // 스토어 비우기
    }
}

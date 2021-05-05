package com.zzinaa.hellospring.repository;

import com.zzinaa.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;


public class MemoryMemberRepository implements MemberRepository{

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
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny(); //루프를 돌면서 name이 같은 것을 찾아 리턴
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); //모든게 쭉 반환됨
    }

    public void clearStore() {
        store.clear();
    }
}

package com.zzinaa.hellospring.repository;

import com.zzinaa.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    //select m from Member m where m.name = ?
    @Override
    Optional<Member> findByName(String name);
}

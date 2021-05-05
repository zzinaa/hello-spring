package com.zzinaa.hellospring;

import com.zzinaa.hellospring.repository.MemberRepository;
import com.zzinaa.hellospring.repository.MemoryMemberRepository;
import com.zzinaa.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}

package com.example.NPKI.security;

import com.example.NPKI.domain.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CustomUserDetails extends User {
    private final Member member;

    public CustomUserDetails(Member member, Collection<? extends GrantedAuthority> authorities) {
        super(member.getAccountId(), member.getPassword(), authorities);
        this.member = member;
    }

    public Member getMember() {
        return member;
    }
}

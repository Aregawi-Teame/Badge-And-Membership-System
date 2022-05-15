package com.membership.service;

import java.util.List;

import com.membership.domain.Member;

public interface MemberService {
	public List<Member> findAll();
	public Member save(Member member);
	public Member findById(Long id);
}

package com.membership.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.membership.domain.Member;
import com.membership.repository.MemberRepository;

@Service
@Transactional
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberRepository memberRepository;
	@Override
	public List<Member> findAll() {
		return memberRepository.findAll();
	}

	@Override
	public Member save(Member member) {
		return memberRepository.save(member);
	}

	@Override
	public Member findById(Long id) {
		return memberRepository.findById(id).get();
	}

}

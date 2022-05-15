package com.membership.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.membership.domain.Badge;
import com.membership.domain.Member;
import com.membership.domain.Role;
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

	@Override
	public Member addMemberBadge(Long memberId, Badge badge) {
		Member member = findById(memberId);
		member.addBadge(badge);
		return save(member);
	}

	@Override
	public Set<Badge> findAllMemberBadges(Long memberId) {
		return findById(memberId).getBadges();
	}

	@Override
	public Set<Role> findAllMemberRoles(Long memberId) {
		return findById(memberId).getRoles();
	}

	@Override
	public Member addMemberRole(Long memberId, Long roleId) {
		Member member = findById(memberId);
		
		// this will update soon
		
		member.addRole(null);
		return save(member);
	}

	@Override
	public Member updateMember(Long memberId, Member updatedMember) {
		Member member =findById(memberId);
		if(updatedMember.getFirstName()!=null) member.setFirstName(updatedMember.getFirstName());
		if(updatedMember.getLastName()!=null) member.setLastName(updatedMember.getLastName());
		if(updatedMember.getEmail()!=null) member.setEmail(updatedMember.getEmail());
		return save(member);
	}

}

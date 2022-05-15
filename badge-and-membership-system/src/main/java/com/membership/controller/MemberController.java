package com.membership.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.membership.domain.Badge;
import com.membership.domain.Member;
import com.membership.domain.Role;
import com.membership.service.MemberService;

@RestController
@RequestMapping("/api/members")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@GetMapping
	public List<Member> findAll(){
		return memberService.findAll();
	}
	@GetMapping("/{id}")
	public Member findById(@PathVariable(name="id") String id){
		Long memberId = Long.parseLong(id);
		return memberService.findById(memberId);
	}
	@PostMapping
	public Member save(@RequestBody Member member) {
		return memberService.save(member);
	}
	
	@PatchMapping("/{id}/badges")
	public Member addMemberBadge(@PathVariable(name="id") String id, @RequestBody Badge badge) {
		Long memberId = Long.parseLong(id);
		return memberService.addMemberBadge(memberId, badge);
	}
	
	@GetMapping("/{id}/badges")
	public Set<Badge> findAllMemberBadges(@PathVariable(name="id") String id){
		Long memberId = Long.parseLong(id);
		return memberService.findAllMemberBadges(memberId);
	}
	
	@GetMapping("/{id}/roles")
	public Set<Role> findAllMemberRoles(@PathVariable(name="id") String id){
		Long memberId = Long.parseLong(id);
		return memberService.findAllMemberRoles(memberId);
	}
	
	@PatchMapping("/{id}/roles")
	public Member addMemberRole(@PathVariable(name="id") String id, @RequestBody String roleId) {
		Long memberId = Long.parseLong(id);
		return memberService.addMemberRole(memberId, memberId);
	}
	
	@PutMapping("/{id}")
	public Member updateMember(@PathVariable(name="id") String id, @RequestBody Member updatedMember) {
		Long memberId = Long.parseLong(id);
		return memberService.updateMember(memberId, updatedMember);
	}
	
}

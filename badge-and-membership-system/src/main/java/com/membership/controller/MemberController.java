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
	public String addBadge(@PathVariable(name="id") String id, @RequestBody Badge badge) {
		Long memberId = Long.parseLong(id);
		Member member = memberService.findById(memberId);
		member.addBadge(badge);
		memberService.save(member);	
		return "Badge Added Successfully!";
	}
	
	@GetMapping("/{id}/badges")
	public Set<Badge> findAllBadges(@PathVariable(name="id") String id){
		Long memberId = Long.parseLong(id);
		Member member = memberService.findById(memberId);
		return member.getBadges();
	}
	
	@GetMapping("/{id}/roles")
	public Set<Role> findAllRole(@PathVariable(name="id") String id){
		Long memberId = Long.parseLong(id);
		Member member = memberService.findById(memberId);
		return member.getRoles();
	}
	
	@PatchMapping("/{id}/roles")
	public String addRole(@PathVariable(name="id") String id, @RequestBody String roleId) {
		Long memberId = Long.parseLong(id);
		Member member = memberService.findById(memberId);
		
		// this will update soon
		
		member.addRole(null);
		memberService.save(member);
		
		return "Role Added Successfully!";
	}
	
	@PutMapping("/{id}")
	public String updateMember(@PathVariable(name="id") String id, @RequestBody Member updatedMember) {
		Long memberId = Long.parseLong(id);
		Member oldMember = memberService.findById(memberId);
		if(updatedMember.getFirstName()!=null) oldMember.setFirstName(updatedMember.getFirstName());
		if(updatedMember.getLastName()!=null) oldMember.setLastName(updatedMember.getLastName());
		if(updatedMember.getEmail()!=null) oldMember.setEmail(updatedMember.getEmail());
		memberService.save(oldMember);
		return "Successfully updated";
	}
	
}

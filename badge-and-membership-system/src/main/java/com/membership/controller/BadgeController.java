package com.membership.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.membership.domain.Badge;
import com.membership.domain.Member;
import com.membership.service.BadgeService;

@RestController
@RequestMapping("/api/badges")
public class BadgeController {

	@Autowired
	private BadgeService badgeService;
	
	@GetMapping
	public List<Badge> findAll(){
		return badgeService.findAll();
	}
	
	@PutMapping("/{id}")
	public Badge updateBadge(@PathVariable(name="id") String id, @RequestBody Badge updatedBadge ) {
		Long badgeId = Long.parseLong(id);
		return badgeService.update(badgeId, updatedBadge);
	}
	
	@GetMapping("/{id}")
	public Badge findById(@PathVariable(name="id") String id) {
		Long badgeId = Long.parseLong(id);
		return badgeService.findById(badgeId);
	}
	
	@GetMapping("/{id}/member")
	public Member findBadgeMember(@PathVariable(name="id") String id) {
		Long badgeId = Long.parseLong(id);
		return badgeService.findBadgeMember(badgeId);
	}
}

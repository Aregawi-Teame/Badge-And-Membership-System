package com.membership.service;

import java.util.List;

import com.membership.domain.Badge;


public interface BadgeService {
	public List<Badge> findAll();
	public Badge findById(Long id);
	public Badge save(Badge badge);
}

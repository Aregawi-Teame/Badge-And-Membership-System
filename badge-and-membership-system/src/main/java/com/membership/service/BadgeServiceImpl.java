package com.membership.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.membership.domain.Badge;
import com.membership.domain.Member;
import com.membership.repository.BadgeRepository;

@Service
@Transactional
public class BadgeServiceImpl implements BadgeService {

	@Autowired
	private BadgeRepository badgeRepository;
	@Override
	public List<Badge> findAll() {
		return badgeRepository.findAll();
	}

	@Override
	public Badge findById(Long id) {
		return badgeRepository.findById(id).get();
	}

	@Override
	public Badge save(Badge badge) {
		return badgeRepository.save(badge);
	}
	
	@Override
	public Badge update(Long badgeId, Badge updatedBadge) {
		Badge oldBadge = findById(badgeId);
		if(updatedBadge.getIssueDate()!=null) oldBadge.setIssueDate(updatedBadge.getIssueDate());
		if(updatedBadge.getExpirationDate()!=null) oldBadge.setExpirationDate(updatedBadge.getExpirationDate());
		oldBadge.setActive(updatedBadge.isActive());
		
		save(oldBadge);
		
		return oldBadge;
	}

	@Override
	public Member findBadgeMember(Long badgeId) {
		return findById(badgeId).getMember();
	}

}

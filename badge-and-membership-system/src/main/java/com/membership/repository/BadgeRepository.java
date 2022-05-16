package com.membership.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.membership.domain.Badge;

@Repository
public interface BadgeRepository extends JpaRepository<Badge, Long>{
	@Query("select badge, member, membership, plan, location from Badge badge join badge.member member join "
			+ "member.membership membership join membership.plan plan "
			+ "join membership.location location"
			+ "where badge.id = :badgeId and location.id = :locationId")
	public List<Object> findBadgeMemberMembershipPlanByBadgeIdAndBarcodeReaderLocationId(
			@Param("badgeId") Long badgeId,
			@Param("locationId") Long locationId);
}

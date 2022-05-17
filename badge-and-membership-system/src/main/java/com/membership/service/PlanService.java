package com.membership.service;

import com.membership.domain.Plan;

import java.util.List;

public interface PlanService {
    public List<Plan> findAll();
    public Plan findById(Long id);
    public Plan save(Plan plan);
    public Plan update(Plan plan, Long id);
    public void deleteById(Long id);
}

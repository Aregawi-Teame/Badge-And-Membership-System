package com.membership.service;

import com.membership.domain.Plan;

import java.util.List;

public interface PlanService {
    public List<Plan> findAll();
    public Plan findById(int id);
    public Plan save(Plan plan);
    public Plan update(int id, Plan plan);
    public void deleteById(int id);
}

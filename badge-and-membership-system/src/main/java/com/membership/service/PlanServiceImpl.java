package com.membership.service;

import com.membership.domain.Plan;
import com.membership.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PlanServiceImpl implements PlanService{
    @Autowired
    private PlanRepository planRepository;

    @Override
    public List<Plan> findAll() {
        return planRepository.findAll();
    }

    @Override
    public Plan findById(int id) {
        return planRepository.getById(id);
    }

    @Override
    public Plan save(Plan plan) {
        return planRepository.save(plan);
    }

    @Override
    public Plan update(Plan plan) {
        return planRepository.save(plan);
    }

    @Override
    public void deleteById(int id) {
        planRepository.deleteById(id);
    }
}

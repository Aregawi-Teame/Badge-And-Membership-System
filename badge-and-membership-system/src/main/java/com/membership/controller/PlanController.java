package com.membership.controller;

import com.membership.domain.Plan;
import com.membership.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plans")
public class PlanController {
    @Autowired
    private PlanService planService;

    @GetMapping
    public List<Plan> getAllPlans(){
        return planService.findAll();
    }

    @GetMapping("/{id}")
    public Plan getAPlan(@PathVariable(name = "id") int id){
        return planService.findById(id);
    }

    @PostMapping
    public Plan addAPlan(@RequestBody Plan plan){
        return planService.save(plan);
    }
    @PutMapping("/{id}")
    public Plan updateAPlan(@PathVariable(name = "id") int id, @RequestBody Plan plan){
        return planService.update(id, plan);
    }

    @DeleteMapping("/{id}")
    public void deleteARole(@PathVariable(name = "id") int id){
        planService.deleteById(id);
    }

}
package com.membership.controller;

import com.membership.domain.ActivityType;
import com.membership.service.ActivityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/activitytypes")
public class ActivityTypeController {
    @Autowired
    ActivityTypeService activityTypeService;

    @GetMapping
    public List<ActivityType> getAllActivityTypes(){
        return activityTypeService.findAll();
    }
    @GetMapping(value = "/{id}")
    public ActivityType getActivityTypeById(@PathVariable long id){
        return activityTypeService.findById(id);
    }

    @PostMapping
    public ActivityType addActivityType(@RequestBody ActivityType activityType){
        return activityTypeService.save(activityType);
    }
}

package com.membership.service;

import com.membership.domain.ActivityType;

import java.util.List;

public interface ActivityTypeService {
    public ActivityType save(ActivityType activityType);
    public ActivityType findById(long id);
    public List<ActivityType> findAll();
}

package com.membership.service;

import com.membership.domain.ActivityType;
import com.membership.repository.ActivityTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityTypeServiceImpl implements ActivityTypeService{

    @Autowired
    ActivityTypeRepository activityTypeRepository;

    @Override
    public ActivityType save(ActivityType activityType) {
        return activityTypeRepository.save(activityType);
    }

    @Override
    public ActivityType findById(long id) {
        return activityTypeRepository.findById(id).get();
    }

    @Override
    public List<ActivityType> findAll() {
        return activityTypeRepository.findAll();
    }
}

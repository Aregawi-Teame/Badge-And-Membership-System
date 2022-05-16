package com.membership.service;

import com.membership.domain.Location;
import com.membership.domain.TimeSlot;
import com.membership.repository.TimeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeSlotServiceImpl implements TimeSlotService{
    @Autowired
    private TimeSlotRepository timeSlotRepository;

    @Autowired
    LocationService locationService;

    @Override
    public TimeSlot findById(long id) {
        return timeSlotRepository.getById(id);
    }

    @Override
    public List<TimeSlot> findAll() {
        return timeSlotRepository.findAll();
    }

    @Override
    public TimeSlot save(TimeSlot timeSlot, long locationId) {
        Location location = locationService.findById(locationId);
        location.getTimeSlots().add(timeSlot);
        return timeSlotRepository.save(timeSlot);
    }

}

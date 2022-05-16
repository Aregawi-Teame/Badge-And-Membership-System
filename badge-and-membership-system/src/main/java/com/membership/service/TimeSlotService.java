package com.membership.service;

import com.membership.domain.TimeSlot;

import java.util.List;

public interface TimeSlotService {
    public TimeSlot findById(long id);
    public List<TimeSlot> findAll();
    public TimeSlot save(TimeSlot timeSlot, long locationId);
}

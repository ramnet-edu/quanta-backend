package com.quanta.service;

import com.quanta.model.Schedule;
import com.quanta.repository.ScheduleRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public Schedule saveSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    public List<Schedule> getScheduleByTeacher(Long teacherId) {
        return scheduleRepository.findByTeacherId(teacherId);
    }
}
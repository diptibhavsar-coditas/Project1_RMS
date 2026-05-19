package com.example.RestaurantOnboarding.repository;

import com.example.RestaurantOnboarding.entity.StaffAttendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceRepository extends JpaRepository<StaffAttendance, Long> {

    List<StaffAttendance> findByStaffId(Long staffId);

    List<StaffAttendance> findByDate(LocalDate date);
}

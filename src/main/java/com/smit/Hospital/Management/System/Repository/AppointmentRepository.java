package com.smit.Hospital.Management.System.Repository;

import com.smit.Hospital.Management.System.Entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}

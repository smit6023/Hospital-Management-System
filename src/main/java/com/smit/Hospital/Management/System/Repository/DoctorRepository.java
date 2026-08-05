package com.smit.Hospital.Management.System.Repository;

import com.smit.Hospital.Management.System.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}

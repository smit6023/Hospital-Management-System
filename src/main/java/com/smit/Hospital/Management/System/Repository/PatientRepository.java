package com.smit.Hospital.Management.System.Repository;

import com.smit.Hospital.Management.System.Entity.Patient;
import com.smit.Hospital.Management.System.Entity.type.BloodGroupType;
import com.smit.Hospital.Management.System.dto.BloodGroupCountResponseEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByName(String name);
    List<Patient> findByGenderAndBloodGroup(String gender, BloodGroupType bloodGroup);
    List<Patient> findByBirthDateOrEmail(LocalDate birthDate, String email);
    List<Patient> findByBirthDateGreaterThan(LocalDate birthDate);
    List<Patient> findByNameContaining(String query);
    List<Patient> findByGenderOrderByNameAsc(String gender);
    Long countByGender(String gender);
    boolean existsByEmail(String email);
    @Query("SELECT p FROM Patient p ")
    List<Patient> getPatients();
    @Query("SELECT p FROM Patient p WHERE p.gender = 'Male' ")
    List<Patient> getMalePatients();
    @Query("SELECT p FROM Patient p WHERE p.gender=:gender")
    List<Patient> getPatientsByGender(@Param("gender") String gender);
    @Query("SELECT p FROM Patient p WHERE p.gender=:gender AND p.bloodGroup=:bloodGroup")
    List<Patient> getPatient(@Param("gender") String gender, @Param("bloodGroup") BloodGroupType bloodGroup);
    @Query("SELECT p FROM Patient p WHERE p.name LIKE %:keyword%")
    List<Patient> search(@Param("keyword") String keyword);
    @Query("SELECT p FROM Patient p ORDER BY p.name ASC")
    List<Patient> orderBy();
    @Query("SELECT COUNT(p) FROM Patient p")
    Long totalPatients();
    @Query("SELECT DISTINCT p.gender FROM Patient p")
    List<String> findDistinctGenders();
    @Query("SELECT p.bloodGroup, COUNT(p) FROM Patient p GROUP BY p.bloodGroup")
    List<Object[]> countPatients();
    @Query(value = "SELECT * FROM patient",nativeQuery = true)
    List<Patient> findAllPatients(PageRequest pageRequest);
    @Transactional
    @Modifying
    @Query("UPDATE Patient p SET p.name =:name WHERE p.id =:id")
    int updateNameWithId(@Param("name") String name, @Param("id") Long id);
    @Query("SELECT NEW com.smit.Hospital.Management.System.dto.BloodGroupCountResponseEntity( p.bloodGroup," +
            " count(p)) FROM Patient p GROUP BY p.bloodGroup")
    List<BloodGroupCountResponseEntity> countEachBloodGroupType();
    @Query(value = "SELECT * FROM Patient",nativeQuery = true)
    Page<Patient> findPatientWithPages(Pageable pageable);
    @Query("SELECT p FROM Patient p LEFT JOIN FETCH p.appointments a LEFT JOIN FETCH a.doctor")
    List<Patient> findAllPatientsWithAppointment();

}

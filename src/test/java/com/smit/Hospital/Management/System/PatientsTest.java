package com.smit.Hospital.Management.System;

import com.smit.Hospital.Management.System.Entity.Patient;
import com.smit.Hospital.Management.System.Entity.type.BloodGroupType;
import com.smit.Hospital.Management.System.Repository.PatientRepository;
import com.smit.Hospital.Management.System.Service.PatientService;
import com.smit.Hospital.Management.System.dto.BloodGroupCountResponseEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PatientsTest {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private PatientService patientService;
    @Test
    public void testPatientRepository(){
        List<Patient> patientList = patientRepository.findAllPatientsWithAppointment();
        System.out.println(patientList);
     //   Patient p1 = new Patient();
       // patientRepository.save(p1);
    }
  @Test
    public void testTransactionMethods(){

       Patient patient = patientRepository.findByName("Diya Verma");
        System.out.println(patient);


       List<Patient> p1 = patientRepository.findByNameContaining("Patel");
       for(Patient patient1: p1){
           System.out.println(patient1);
       }



      List<Patient> patientList = patientRepository.findByGenderAndBloodGroup("Female",BloodGroupType.O_Positive);
      for(Patient patient1: patientList){
          System.out.println(patient1);
      }

     List<Patient> patients = patientRepository.findByBirthDateOrEmail(LocalDate.of(2005,11,11),
             "diyaverma@gmail.com");
      for(Patient patient1: patients){
          System.out.println(patient1);
      }

      List<Patient> patients1 = patientRepository.findByBirthDateGreaterThan(LocalDate.of(2005,01,01));
      for(Patient patient1: patients1){
          System.out.println(patient1);
      }

      List<Patient> patients2 = patientRepository.findByGenderOrderByNameAsc("Male");
      for(Patient patient1: patients2){
          System.out.println(patient1);
      }

      Long patient1 = patientRepository.countByGender("Male");
      System.out.println(patient1);

      if(patientRepository.existsByEmail("smit12@gmail.com")){
          throw new IllegalArgumentException("Email already exists");
      }

      System.out.println(patientRepository.getPatients());

      System.out.println(patientRepository.getMalePatients());

      System.out.println(patientRepository.getPatientsByGender("Female"));

      System.out.println(patientRepository.getPatient("Female", BloodGroupType.O_Positive));

      System.out.println(patientRepository.search("Patel"));

      System.out.println(patientRepository.orderBy());

      System.out.println(patientRepository.totalPatients());

      System.out.println(patientRepository.findDistinctGenders());

      List<Object[]> objects = patientRepository.countPatients();
      for(Object[] objects1: objects){
          System.out.println(objects1[0]+" "+objects1[1]);
      }

      List<Patient> patients3 = patientRepository.findAllPatients(PageRequest.of(pageNumber, pageSize));
      for(Patient patient2: patients3){
          System.out.println(patient2);
      }

      int rowsAffected = patientRepository.updateNameWithId("Smit Kapuriya", 3L);
      System.out.println(rowsAffected);

      List<BloodGroupCountResponseEntity> bloodGroupCountResponse = patientRepository.countEachBloodGroupType();
      for(BloodGroupCountResponseEntity bloodGroupCountResponse1: bloodGroupCountResponse){
          System.out.println(bloodGroupCountResponse1);
      }

      Page<Patient> patients4 = patientRepository.findPatientWithPages(PageRequest.of(0,4));
      for(Patient patient2: patients4){
          System.out.println(patient2);
      }
  }
}

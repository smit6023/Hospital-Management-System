package com.smit.Hospital.Management.System;

import com.smit.Hospital.Management.System.Entity.Appointment;
import com.smit.Hospital.Management.System.Service.AppointmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class AppointmentTest {
    @Autowired
    private  AppointmentService appointmentService;
    @Test
    public void createNewAppointmentTest(){
        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2025, 11, 1, 14, 0, 0))
                .reason("Cancer")
                .build();


      //  Appointment appointment = Appointment.builder()
        //        .appointmentTime(LocalDateTime.of(2026,07,17,10,00,0))
          //     .reason("Cancer")
            //    .build();
       // var newAppointment = appointmentService.createNewAppointment(appointment,1L,2L);
       // System.out.println(newAppointment);

      //  var updatedAppointment = appointmentService.reAssignAppointmentToOtherDoctor(newAppointment.getId(), 3L);
       // System.out.println(updatedAppointment);
    }
}

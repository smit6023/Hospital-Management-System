package com.smit.Hospital.Management.System.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime appointmentTime;


    private String reason;

    @ManyToOne

    @JoinColumn(name = "patient_id") // patient is required and not nullable
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)

    @JoinColumn()
    private Doctor doctor;
}

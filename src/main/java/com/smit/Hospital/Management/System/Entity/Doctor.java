package com.smit.Hospital.Management.System.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column( length = 100)
    private String name;
    @Column(length = 100)
    private String specialization;
    @Column( unique = true, length = 100)
    private String email;
    @OneToOne
    @MapsId
    private User user;
    @ManyToMany(mappedBy = "doctors")
    private List<Department> departments = new ArrayList<>();
    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments = new ArrayList<>();
}

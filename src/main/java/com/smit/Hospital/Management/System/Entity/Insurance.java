package com.smit.Hospital.Management.System.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (unique = true, length = 50)
    private String policyNumber;
    @Column( length = 100)
    private String provider;

    private LocalDate validTill;
    @CreationTimestamp
    @Column( updatable = false)
    private LocalDateTime createdAt;
    @OneToOne(mappedBy = "insurance")  // inverse side

    private Patient patient;

}

package com.manuel.springdatajpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_student",
    //uniqueConstraint- making a unique column in database
        uniqueConstraints = @UniqueConstraint(name = "email_unigue", columnNames = "email_address")
  )
public class Student {
    @Id
    // for primary key generation I should have to use the @SequenceGenerator like so,
    @SequenceGenerator(name = "student_sequence", sequenceName = "sequence_name", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    private long studentId;
    private String firstName;
    private String lastName;
    // custom defining the attributes of the table
    @Column(name="email_address", nullable = false)
    private String emailId;
    @Embedded
    private Guardian guardian;
//    private String guardianName;
//    private String guardianEmail;
//    private String guardianMobile;
}

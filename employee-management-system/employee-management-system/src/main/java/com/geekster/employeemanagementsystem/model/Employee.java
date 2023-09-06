package com.geekster.employeemanagementsystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@Entity
@Table(name="employee_table")
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int employeeId;
    @Column(name="first_name")
   private String firstName;
    @Column(name="last_name")
    private String lastName;

    @Column(name="phone_number")
    @Length(min=10, max=13,message="please enter valid phone number")
   private String phoneNumber;
    @Column(name="email")
    @Email(message = "please enter valid email")
   private String email;
    @Column(name="job_role")
   private String jobRole;
    @Column(name="salary")
    private int salary;
    @Column(name="address")
    private String address;
}

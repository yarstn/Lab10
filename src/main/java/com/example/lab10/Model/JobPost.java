package com.example.lab10.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class JobPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "varchar(20) not null")
    @NotEmpty(message = "title must not be empty")
    @Size(min = 5, message = "title must be at least 5 characters long")
    private String title;
    @Column(columnDefinition = "varchar(20) not null")
    @NotEmpty(message = "description must not be empty")
    private String description;
    @Column(columnDefinition = "varchar(20) not null")
    @NotEmpty(message = "location must not be empty")
    private String location;
    @Column(columnDefinition = "int not null")
    @NotNull(message = "salary must not be empty")
    @Positive(message = "must be positive")
    private int salary;
    private Date postingDate;
}

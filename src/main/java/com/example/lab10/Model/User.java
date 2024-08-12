package com.example.lab10.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(20) not null ")
//    @Check(constraints = "name IN(name ~ '^[a-zA-Z]+$')")
    @NotEmpty(message = "Username must not be empty")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Username must contain only letters")
    @Size(min = 5, message = "Username must be at least 5 characters long")
    private String name;

    @Email
    @Column(columnDefinition =("varchar(30) not null unique") )
    private String email;

    @NotNull(message = "age must not be null")
    @Min(value = 21, message = "age must be more than 21")
    @Column(columnDefinition =("int not null ") )
    private int age;


    @NotEmpty(message = "password must not be empty")
    @Column(columnDefinition =("varchar(30) not null ") )
    private String password;


    @NotEmpty(message = "role must not be empty")
    @Column(columnDefinition =("varchar(11) not null ") )
    @Pattern(regexp = "JOB_SEEKER|EMPLOYER", message = "role must be JOB_SEEKER|EMPLOYER ")
    @Check(constraints = "role IN('JOB_SEEKER','EMPLOYER')")
    private String role;
}

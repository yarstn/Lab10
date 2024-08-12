package com.example.lab10.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition =("int not null ") )
    @NotNull(message = "userId must not be null")
    private int userId;

    @Column(columnDefinition =("int not null ") )
    @NotNull(message = "jobPostId must not be null")
    private int jobPostId;
}

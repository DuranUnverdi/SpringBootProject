package com.spring_rest_api.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "department")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    @Column(name = "department_name")
    private String departmentName;


}

package com.spring_rest_api.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoStudentIU {
    @NotEmpty(message = "First name must not be empty")
    @Size(min = 3, max = 50, message = "First name must be between 2 and 50 characters")
    private String firstName;

    @NotEmpty(message = "Last name must not be empty")
    @Size(min = 3, max = 50, message = "Last name must be between 2 and 50 characters")
    private String lastName;

    @NotNull(message = "Birth date must not be null")
    @Past(message = "Birth date must be a past date")
    private Date birthDate;

    @Size(min = 11, max = 11, message = "TCKN must be exactly 11 characters")
    private  String identityNumber;
}

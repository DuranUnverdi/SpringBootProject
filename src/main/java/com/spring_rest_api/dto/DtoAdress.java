package com.spring_rest_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoAdress {
    private Long id;
    private String street;
    private String city;
    private String state;
    private String zipCode;
}

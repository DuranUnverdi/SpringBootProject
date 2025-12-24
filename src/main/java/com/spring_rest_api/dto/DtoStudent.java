package com.spring_rest_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoStudent {
    private Integer id;
    private String firstName;
    private String lastName;
    private List<DtoCourse> courses=new ArrayList<>();
}

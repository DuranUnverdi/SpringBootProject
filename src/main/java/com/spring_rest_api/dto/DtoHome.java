package com.spring_rest_api.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoHome {
    private Long id;
    private Long price;
    private List<DtoRoom> room = new ArrayList<>(); // <-- BU ŞART
}

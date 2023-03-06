package com.assignment.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class BatterySaveRequestDTO implements Serializable {
    private String name;
    private Long postcode;
    private Double capacityInWatt;
}

package com.assignment.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class BatterySearchResponseDTO implements Serializable {

    private List<String> batteryList;
    private Double total;
    private Double averageCapacity;
}

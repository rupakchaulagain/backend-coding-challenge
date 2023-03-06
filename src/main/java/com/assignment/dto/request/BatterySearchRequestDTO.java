package com.assignment.dto.request;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
public class BatterySearchRequestDTO implements Serializable {

    @NotNull
    private Long startRange;
    @NotNull
    private Long endRange;
}

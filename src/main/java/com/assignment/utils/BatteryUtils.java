package com.assignment.utils;

import com.assignment.dto.request.BatterySaveRequestDTO;
import com.assignment.model.Battery;

import java.util.ArrayList;
import java.util.List;

public class BatteryUtils {
    public static List<Battery> parseToSaveBattery(List<BatterySaveRequestDTO> batterySaveRequestDTOList) {

        List<Battery> batteryList = new ArrayList<>();
        batterySaveRequestDTOList.forEach(batteryRequest -> {
            Battery battery = Battery.builder()
                    .name(batteryRequest.getName())
                    .postcode(batteryRequest.getPostcode())
                    .capacityInWatt(batteryRequest.getCapacityInWatt())
                    .build();
            batteryList.add(battery);
        });

        return batteryList;


    }
}

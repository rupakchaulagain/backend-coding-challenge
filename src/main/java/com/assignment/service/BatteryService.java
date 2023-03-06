package com.assignment.service;

import com.assignment.dto.request.BatterySaveRequestDTO;
import com.assignment.dto.request.BatterySearchRequestDTO;
import com.assignment.dto.response.BatterySearchResponseDTO;

import java.util.List;

public interface BatteryService {
    void save(List<BatterySaveRequestDTO> batterySaveRequestDTOList);
    BatterySearchResponseDTO fetchBatteries(BatterySearchRequestDTO requestDTO);
}

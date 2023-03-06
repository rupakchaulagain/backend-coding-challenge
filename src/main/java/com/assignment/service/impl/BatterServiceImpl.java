package com.assignment.service.impl;

import com.assignment.dto.request.BatterySaveRequestDTO;
import com.assignment.dto.request.BatterySearchRequestDTO;
import com.assignment.dto.response.BatterySearchResponseDTO;
import com.assignment.model.Battery;
import com.assignment.repository.BatteryRepository;
import com.assignment.service.BatteryService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import static com.assignment.utils.BatteryUtils.parseToSaveBattery;

@Service
@Transactional
public class BatterServiceImpl implements BatteryService {

    private final BatteryRepository batteryRepository;

    public BatterServiceImpl(BatteryRepository batteryRepository) {
        this.batteryRepository = batteryRepository;
    }

    @Override
    public void save(List<BatterySaveRequestDTO> batterySaveRequestDTOList) {

        if (!batterySaveRequestDTOList.isEmpty()) {
            List<Battery> batterListToBeSaved = parseToSaveBattery(batterySaveRequestDTOList);
            batteryRepository.saveAll(batterListToBeSaved);
        }

    }

    @Override
    public BatterySearchResponseDTO fetchBatteries(BatterySearchRequestDTO requestDTO) {

        List<Battery> batterList = batteryRepository.findAll();
        batterList = batterList.stream()
                .filter(battery -> requestDTO.getStartRange() <= battery.getPostcode() &&
                        battery.getPostcode() <= requestDTO.getEndRange())
                .sorted(Comparator.comparing(Battery::getName))
                .collect(Collectors.toList());

        List<String> batteries = batterList.stream().map(battery -> battery.getName()).collect(Collectors.toList());
        DoubleSummaryStatistics summaryStatistics = batterList.stream()
                .mapToDouble(Battery::getCapacityInWatt).summaryStatistics();

        BatterySearchResponseDTO responseDTO = new BatterySearchResponseDTO();
        responseDTO.setBatteryList(batteries);
        responseDTO.setTotal(summaryStatistics.getSum());
        responseDTO.setAverageCapacity(summaryStatistics.getAverage());

        return responseDTO;
    }
}

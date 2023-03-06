package com.assignment.resource;

import com.assignment.dto.request.BatterySaveRequestDTO;
import com.assignment.dto.request.BatterySearchRequestDTO;
import com.assignment.service.BatteryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.assignment.constants.WebResourceKeyConstants.BatteryConstants.BASE_BATTERY;
import static java.net.URI.create;
import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(BASE_BATTERY)
public class BatteryResource {

    private final BatteryService batteryService;

    public BatteryResource(BatteryService batteryService) {
        this.batteryService = batteryService;
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody List<BatterySaveRequestDTO> requestDTO) {
        batteryService.save(requestDTO);
        return created(create(BASE_BATTERY)).build();
    }

    @PutMapping
    public ResponseEntity<?> fetchBatteries(@RequestBody BatterySearchRequestDTO requestDTO) {
        return ok(batteryService.fetchBatteries(requestDTO));
    }
}

package org.example.carbon_spring_boot.carbon;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarbonController {

    private final CarbonService carbonService;

    public CarbonController(CarbonService carbonService) {
        this.carbonService = carbonService;
    }

    @GetMapping("/api/carbon/footprint")
    public ResponseEntity<CarbonFootprintResponse> getCarbonFootprint(
            @RequestParam String type,
            @RequestParam double value) {

        CarbonFootprintResponse response = carbonService.getCarbonFootprint(type, value);
        return ResponseEntity.ok(response);
    }
}


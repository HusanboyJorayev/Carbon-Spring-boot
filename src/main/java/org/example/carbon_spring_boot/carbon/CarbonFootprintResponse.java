package org.example.carbon_spring_boot.carbon;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarbonFootprintResponse {

    private String activityType;
    private double value;
    private double carbonFootprint;

}


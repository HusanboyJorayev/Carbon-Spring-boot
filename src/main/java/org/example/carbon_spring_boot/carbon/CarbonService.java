package org.example.carbon_spring_boot.carbon;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class CarbonService {

    private final RestTemplate restTemplate;

    @Value("${carbon.api.url}")
    private String carbonApiUrl;

    @Value("${carbon.api.key}")
    private String apiKey;

    public CarbonService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CarbonFootprintResponse getCarbonFootprint(String activityType, double value) {
        String url = UriComponentsBuilder.fromHttpUrl(carbonApiUrl)
                .queryParam("type", activityType)
                .queryParam("value", value)
                .queryParam("key", apiKey)
                .toUriString();

        return restTemplate.getForObject(url, CarbonFootprintResponse.class);
    }
}


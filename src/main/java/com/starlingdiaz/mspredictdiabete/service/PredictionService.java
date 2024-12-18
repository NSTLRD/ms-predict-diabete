/**
 * @author Starling Diaz on 12/18/2024.
 * @Github https://github.com/NSTLRD
 * @Website https://mentorly.blog/
 * @Academy https://www.mentor-ly.com/
 * @version ms-predict-diabete 1.0
 * @since 12/18/2024.
 */

package com.starlingdiaz.mspredictdiabete.service;

import com.starlingdiaz.mspredictdiabete.model.PredictionRequest;
import com.starlingdiaz.mspredictdiabete.model.PredictionResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PredictionService {

    private final RestTemplate restTemplate;

    @Value("${flask.api.base.url}")
    private String flaskApiBaseUrl;

    public PredictionService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public PredictionResponse getPrediction(PredictionRequest request) {
        String url = flaskApiBaseUrl + "/predict";
        return restTemplate.postForObject(url, request, PredictionResponse.class);
    }
}
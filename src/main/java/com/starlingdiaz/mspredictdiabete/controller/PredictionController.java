/**
 * @author Starling Diaz on 12/18/2024.
 * @Github https://github.com/NSTLRD
 * @Website https://mentorly.blog/
 * @Academy https://www.mentor-ly.com/
 * @version ms-predict-diabete 1.0
 * @since 12/18/2024.
 */

package com.starlingdiaz.mspredictdiabete.controller;

import com.starlingdiaz.mspredictdiabete.model.PredictionRequest;
import com.starlingdiaz.mspredictdiabete.model.PredictionResponse;
import com.starlingdiaz.mspredictdiabete.service.PredictionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/predictions")
public class PredictionController {

    private static final Logger log = LoggerFactory.getLogger(PredictionController.class);
    private final PredictionService predictionService;

    public PredictionController(PredictionService predictionService) {
        this.predictionService = predictionService;
    }

    @PostMapping
    public ResponseEntity<PredictionResponse> predict(@RequestBody PredictionRequest request) {
        PredictionResponse response = predictionService.getPrediction(request);
        log.info(String.valueOf(response));
        return ResponseEntity.ok(response);

    }
}

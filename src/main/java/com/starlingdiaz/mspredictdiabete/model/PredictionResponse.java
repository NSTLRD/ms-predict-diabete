/**
 * @author Starling Diaz on 12/18/2024.
 * @Github https://github.com/NSTLRD
 * @Website https://mentorly.blog/
 * @Academy https://www.mentor-ly.com/
 * @version ms-predict-diabete 1.0
 * @since 12/18/2024.
 */

package com.starlingdiaz.mspredictdiabete.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PredictionResponse {
    @JsonProperty("classification")
    private String classification;
    @JsonProperty("interpretation")
    private String interpretation;
    @JsonProperty("prediction")
    private int prediction;
}

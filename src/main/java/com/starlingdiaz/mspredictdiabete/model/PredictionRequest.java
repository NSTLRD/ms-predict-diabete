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
public class PredictionRequest {
    @JsonProperty("HighBP")
    private int highBP;

    @JsonProperty("HighChol")
    private int highChol;

    @JsonProperty("CholCheck")
    private int cholCheck;

    @JsonProperty("BMI")
    private int bmi;

    @JsonProperty("Smoker")
    private int smoker;

    @JsonProperty("Stroke")
    private int stroke;

    @JsonProperty("HeartDiseaseorAttack")
    private int heartDiseaseorAttack;

    @JsonProperty("PhysActivity")
    private int physActivity;

    @JsonProperty("Fruits")
    private int fruits;

    @JsonProperty("Veggies")
    private int veggies;

    @JsonProperty("HvyAlcoholConsump")
    private int hvyAlcoholConsump;

    @JsonProperty("AnyHealthcare")
    private int anyHealthcare;

    @JsonProperty("NoDocbcCost")
    private int noDocbcCost;

    @JsonProperty("GenHlth")
    private int genHlth;

    @JsonProperty("MentHlth")
    private int mentHlth;

    @JsonProperty("PhysHlth")
    private int physHlth;

    @JsonProperty("DiffWalk")
    private int diffWalk;

    @JsonProperty("Sex")
    private int sex;

    @JsonProperty("Age")
    private int age;

    @JsonProperty("Education")
    private int education;

    @JsonProperty("Income")
    private int income;
}
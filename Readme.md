# Scientific Article: Implementation of a Hybrid System for Diabetes Prediction with Flask and Spring Boot

## Abstract

This paper presents the development of a hybrid system integrating a Python-based API using Flask for diabetes prediction through Machine Learning algorithms and a Java API utilizing Spring Boot for its consumption. This system demonstrates an effective solution to address prediction challenges through a scalable and modular approach. The development includes detailed explanations of the technologies used, step-by-step implementations, and thorough validation.

---

## Introduction

Diabetes is one of the leading causes of chronic diseases worldwide. With technological advancements, early diabetes prediction using Machine Learning algorithms enables informed decision-making that can save lives. This article documents the development of a modular system that allows training a prediction model and consuming its results through a microservices-based architecture.

---

## Technologies Used

### Python and Flask

- **Python** is a widely used programming language in Machine Learning.
- **Flask** is a lightweight framework that allows rapid creation of RESTful APIs.

### Java and Spring Boot

- **Java** is a robust programming language used for enterprise applications.
- **Spring Boot** facilitates the creation of scalable microservices and RESTful APIs.

### Additional Tools

- **Pandas:** Data manipulation.
- **scikit-learn:** Model training.
- **RestTemplate:** HTTP client in Spring Boot.
- **Postman:** API testing.

---

## Development

### Step 1: Dataset Preparation and Model Training

#### Dataset

The `cdc_diabetes_health_indicators` dataset from the UCI Machine Learning Repository was used. This dataset contains indicators such as high blood pressure, Body Mass Index (BMI), and physical activity.

#### Model Training

The prediction model was trained using a Random Forest classifier:

1. Import libraries and load the dataset:

   ```python
   from ucimlrepo import fetch_ucirepo
   from sklearn.ensemble import RandomForestClassifier
   from sklearn.model_selection import train_test_split
   import joblib
   import pandas as pd

   # Load the dataset
   data = fetch_ucirepo(id=891)
   X = data.data.features
   y = data.data.targets
   ```

2. Split the data:

   ```python
   X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)
   ```

3. Train and save the model:

   ```python
   model = RandomForestClassifier(n_estimators=100, random_state=42)
   model.fit(X_train, y_train)
   joblib.dump(model, "models/diabetes_health_model.pkl")
   ```

---

### Step 2: Flask API Implementation

#### Project Structure

```
flask-diabetes-prediction/
├── app.py
├── models/
│   └── diabetes_health_model.pkl
├── requirements.txt
├── scripts/
└── data/
```

#### API Implementation

The `app.py` file defines the API behavior:

1. **Load the model:**

   ```python
   from flask import Flask, request, jsonify
   import joblib
   import pandas as pd

   app = Flask(__name__)
   model = joblib.load("models/diabetes_health_model.pkl")
   ```

2. **Create the `/predict` endpoint:**

   ```python
   @app.route("/predict", methods=["POST"])
   def predict():
       data = request.get_json()
       features_df = pd.DataFrame([data])
       prediction = model.predict(features_df)
       return jsonify({
           "prediction": int(prediction[0]),
           "classification": "Prediabetes" if int(prediction[0]) == 1 else "No Diabetes Detected",
           "interpretation": "Diabetes detected" if int(prediction[0]) == 1 else "No diabetes detected"
       })
   ```

3. **Run the API:**

   ```bash
   python app.py
   ```

---

### Step 3: Spring Boot Client Creation

#### Project Structure

```
springboot-diabetes-client/
├── src/main/java/
│   ├── com/starlingdiaz/mspredictdiabete/
│   │   ├── controller/
│   │   ├── model/
│   │   └── service/
├── src/main/resources/
│   └── application.properties
└── pom.xml
```

#### Implementation

1. **Define model classes:**

   ```java
   @Data
   public class PredictionRequest {
       private int highBP;
       private int highChol;
       private int cholCheck;
       private int bmi;
       private int smoker;
       private int stroke;
       private int heartDiseaseorAttack;
       private int physActivity;
       private int fruits;
       private int veggies;
       private int hvyAlcoholConsump;
       private int anyHealthcare;
       private int noDocbcCost;
       private int genHlth;
       private int mentHlth;
       private int physHlth;
       private int diffWalk;
       private int sex;
       private int age;
       private int education;
       private int income;
   }

   @Data
   public class PredictionResponse {
       private int prediction;
       private String classification;
       private String interpretation;
   }
   ```

2. **Create the client service:**

   ```java
   @Service
   public class PredictionService {
       private final RestTemplate restTemplate;
       
       @Value("${flask.api.base.url}")
       private String flaskApiBaseUrl;

       public PredictionResponse getPrediction(PredictionRequest request) {
           return restTemplate.postForObject(flaskApiBaseUrl + "/predict", request, PredictionResponse.class);
       }
   }
   ```

3. **Create the controller:**

   ```java
   @RestController
   @RequestMapping("/api/v1/predictions")
   public class PredictionController {
       private final PredictionService predictionService;

       @PostMapping
       public ResponseEntity<PredictionResponse> predict(@RequestBody PredictionRequest request) {
           return ResponseEntity.ok(predictionService.getPrediction(request));
       }
   }
   ```

---

## Validation

Exhaustive testing was performed to ensure that both APIs function correctly and return the expected results. Postman was used to send POST requests to both the Flask API and the Spring Boot API. All scenarios were validated with test data.

---

## Conclusion

This project demonstrates the efficiency of integrating Python and Java to develop a scalable diabetes prediction system. Flask is used to train and expose the model, while Spring Boot serves as a robust client to consume the API. This modular approach allows the system to be extended in the future to include new algorithms or functionalities.

---

## References

1. [UCI Machine Learning Repository](https://archive.ics.uci.edu/ml/index.php)
2. Flask Documentation: [https://flask.palletsprojects.com/](https://flask.palletsprojects.com/)
3. Spring Boot Documentation: [https://spring.io/projects/spring-boot](https://spring.io/projects/spring-boot)

Author: Starling Diaz

LinkedIn: [https://www.linkedin.com/in/starling-diaz-908225181/](https://www.linkedin.com/in/starling-diaz-908225181/)

Mentorly Blog: [https://mentorly.blog/](https://mentorly.blog/)

github: [https://github.com/NSTLRD](https://github.com/NSTLRD)


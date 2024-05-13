# SSE with Spring Boot

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](https://github.com/robinhosz/SSE-With-SpringBoot/blob/master/LICENSE)

🌐 This repository contains an example implementation of Server-Sent Events (SSE) using the Spring Boot framework. SSE is a technology that enables a server to push asynchronous updates to a web client over a single, long-lived HTTP connection.

## Contents

1. 🖥️ **src/main/java/github/io/robinhosz/sse/controller/SSEController.java:** This file contains the controller responsible for providing a continuous stream of SSE events to clients.
2. 🛠️ **src/main/java/github/io/robinhosz/sse/service/SensorSimulatorService.java:** Here lies the service that simulates sensor data generation at regular intervals.
3. 📝 **src/main/java/github/io/robinhosz/sse/model/SensorData.java:** This file defines the structure of sensor data.
4. ✅ **src/test/java/github/io/robinhosz/sse/controller/SSEControllerTest.java:** Contains unit tests for the SSE controller.
5. ✅ **src/test/java/github/io/robinhosz/sse/service/SensorSimulatorServiceTest.java:** Includes unit tests for the sensor data simulation service.

## How to Run

1. 🛠️ Make sure you have Java JDK and Maven installed on your system.
2. 📥 Clone this repository to your local machine.

   ```bash
   git clone https://github.com/robinhosz/SSE-With-SpringBoot.git
   ```
3. ⚙️ Navigate to the cloned directory and run the application using Maven:

    ```bash
    cd sse-spring-boot
    mvn spring-boot:run
    ```
4. 🚀 The server will start and be available at http://localhost:8080.
  
5. 🌐Open a web browser and access http://localhost:8080/events to see SSE events being continuously streamed.

## Note: 
This is a basic example and can be expanded to meet more complex SSE application requirements.

## Contribute
 * 🤝 Feel free to submit pull requests with enhancements.
 * 🐞 Report issues or suggest new features using the Issues tab.

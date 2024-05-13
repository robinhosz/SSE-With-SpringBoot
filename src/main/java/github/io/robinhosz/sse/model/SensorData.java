package github.io.robinhosz.sse.model;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Random;

public record SensorData(String sensorId, String dataType, double value, LocalDateTime timestamp) {


    public static SensorData createWithCurrentTimestamp(String sensorId, String dataType, double value) {
        return new SensorData(sensorId, dataType, value, LocalDateTime.now());
    }

    public static SensorData generateRandomSensorData() throws NoSuchAlgorithmException {
        Random rand = SecureRandom.getInstanceStrong();
        String[] sensorIds = {"sensor1", "sensor2", "sensor3"};
        String[] dataTypes = {"temperature", "humidity", "pressure"};
        double value = rand.nextDouble() * 100;
        String sensorId = sensorIds[rand.nextInt(sensorIds.length)];
        String dataType = dataTypes[rand.nextInt(dataTypes.length)];
        return new SensorData(sensorId, dataType, value, LocalDateTime.now());
    }
}
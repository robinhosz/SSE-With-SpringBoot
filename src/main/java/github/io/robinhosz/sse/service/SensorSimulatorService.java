package github.io.robinhosz.sse.service;

import github.io.robinhosz.sse.model.SensorData;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.security.NoSuchAlgorithmException;
import java.time.Duration;

@Service
public class SensorSimulatorService {

    public Flux<SensorData> simulateSensorData() {
        return Flux.interval(Duration.ofSeconds(1))
                .map(sequence -> {
                    try {
                        return SensorData.generateRandomSensorData();
                    } catch (NoSuchAlgorithmException e) {
                        throw new RuntimeException(e);
                    }
                });
    }
}

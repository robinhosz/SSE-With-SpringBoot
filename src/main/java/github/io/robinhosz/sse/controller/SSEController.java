package github.io.robinhosz.sse.controller;

import github.io.robinhosz.sse.model.SensorData;
import github.io.robinhosz.sse.service.SensorSimulatorService;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.UUID;

@RestController
public class SSEController {

    private final SensorSimulatorService sensorSimulatorService;

    public SSEController(SensorSimulatorService sensorSimulatorService) {
        this.sensorSimulatorService = sensorSimulatorService;
    }


    @GetMapping("/events")
    public Flux<ServerSentEvent<SensorData>> streamEvents() {
        return Flux.interval(Duration.ofSeconds(1))
                .flatMap(sequence ->
                        sensorSimulatorService.simulateSensorData()
                                .map(sensorData -> ServerSentEvent.<SensorData>builder()
                                        .id(UUID.randomUUID().toString())
                                        .event("sensor-data")
                                        .data(sensorData)
                                        .build())
                );
    }
}

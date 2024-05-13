package github.io.robinhosz.sse.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.test.StepVerifier;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SensorSimulatorServiceTest {

    @Autowired
    private SensorSimulatorService sensorSimulatorService;

    @Test
    void simulateSensorData() {
        // Obter um fluxo de dados simulados do serviço
        var flux = sensorSimulatorService.simulateSensorData().take(3); // Limitando a 3 eventos para o teste

        // Verificar os dados recebidos
        StepVerifier.create(flux)
                .expectNextMatches(data -> data.value() >= 0 && data.value() <= 100) // Verifica se o valor está no intervalo esperado
                .expectNextMatches(data -> data.value() >= 0 && data.value() <= 100)
                .expectNextMatches(data -> data.value() >= 0 && data.value() <= 100)
                .thenCancel() // Cancela a assinatura após receber os eventos esperados
                .verify(Duration.ofSeconds(4)); // Verifica dentro de um período de tempo
    }
}
package github.io.robinhosz.sse.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.test.StepVerifier;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SSEControllerTest {

    @Autowired
    private SSEController sseController;

    @Test
    void streamEvents() {
        // Obter um fluxo de eventos do controlador
        var flux = sseController.streamEvents().take(3); // Limitando a 3 eventos para o teste

        // Verificar os eventos recebidos
        StepVerifier.create(flux)
                .expectNextMatches(event -> "sensor-data".equals(event.event()) && event.data() != null) // Verifica o formato do evento
                .expectNextMatches(event -> "sensor-data".equals(event.event()) && event.data() != null)
                .expectNextMatches(event -> "sensor-data".equals(event.event()) && event.data() != null)
                .thenCancel() // Cancela a assinatura após receber os eventos esperados
                .verify(Duration.ofSeconds(5)); // Verifica dentro de um período de tempo

        // Verificar comportamento assíncrono
        StepVerifier.create(flux)
                .thenAwait(Duration.ofSeconds(4)) // Aguarda 4 segundos
                .expectNextCount(1) // Espera receber mais um evento após 4 segundos
                .thenCancel() // Cancela a assinatura após receber o próximo evento
                .verify(Duration.ofSeconds(5)); // Verifica dentro de um período de tempo
    }
}
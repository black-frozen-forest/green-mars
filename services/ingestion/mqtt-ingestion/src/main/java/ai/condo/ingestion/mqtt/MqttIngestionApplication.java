package ai.condo.ingestion.mqtt;

import ai.condo.kafka.KafkaProducerAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(KafkaProducerAutoConfiguration.class)
public class MqttIngestionApplication {
    public static void main(String[] args) {
        SpringApplication.run(MqttIngestionApplication.class, args);
    }
}
package ai.condo.ingestion.grpc;

import ai.condo.kafka.KafkaProducerAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({KafkaProducerAutoConfiguration.class})
@ComponentScan(basePackages = {"ai.condo.ingestion.grpc"})
public class GrpcIngestionApplication {
    public static void main(String[] args) {
        SpringApplication.run(GrpcIngestionApplication.class, args);
    }
}

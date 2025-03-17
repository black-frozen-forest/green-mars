package ai.condo.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
@EnableConfigurationProperties(KafkaProducerProperties.class)
@ConditionalOnProperty(prefix = "ai.condo.kafka", name = "enabled", havingValue = "true", matchIfMissing = true)
public class KafkaProducerAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean
    public KafkaEventPublisher kafkaEventPublisher(KafkaProducerProperties properties) {
        return new KafkaEventPublisher(properties.getBootstrapServers(), properties.getTopic());
    }
}

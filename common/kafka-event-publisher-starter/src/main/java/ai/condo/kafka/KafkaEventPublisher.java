package ai.condo.kafka;

import ai.condo.proto.DetectionBatch;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class KafkaEventPublisher {
    private final KafkaProducer<String, byte[]> producer;
    private final String topic;

    public KafkaEventPublisher(String bootstrapServers, String topic) {
        this.topic = topic;
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.ByteArraySerializer");
        this.producer = new KafkaProducer<>(props);
    }

    public void sendMessage(String key, DetectionBatch detectionBatch) {
        byte[] serializedData = detectionBatch.toByteArray();
        producer.send(new ProducerRecord<>(topic, key, serializedData));
    }
}

package ai.condo.ingestion.mqtt;

import ai.condo.kafka.KafkaEventPublisher;
import ai.condo.proto.DetectionBatch;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MqttIngestionService implements MqttCallback {

    private final KafkaEventPublisher kafkaEventPublisher;
    private final MqttClient mqttClient;

    public MqttIngestionService(KafkaEventPublisher kafkaEventPublisher,
                                @Value("${mqtt.broker-url}") String brokerUrl,
                                @Value("${mqtt.client-id}") String clientId,
                                @Value("${mqtt.topic}") String topic) throws MqttException {
        this.kafkaEventPublisher = kafkaEventPublisher;

        // Create MQTT Client
        this.mqttClient = new MqttClient(brokerUrl, clientId, new MemoryPersistence());
        MqttConnectOptions options = new MqttConnectOptions();
        options.setAutomaticReconnect(true);
        options.setCleanSession(true);
        this.mqttClient.setCallback(this);
        this.mqttClient.connect(options);
        this.mqttClient.subscribe(topic); // Subscribe to the configured topic
    }

    @Override
    public void connectionLost(Throwable cause) {
        System.err.println("MQTT Connection lost: " + cause.getMessage());
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) {
        try {
            DetectionBatch detectionBatch = DetectionBatch.parseFrom(message.getPayload()); // Deserialize Protobuf
            kafkaEventPublisher.sendMessage("mqtt-detection", detectionBatch);
        } catch (Exception e) {
            System.err.println("Failed to process MQTT message: " + e.getMessage());
        }
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        System.out.println("MQTT message delivered.");
    }
}

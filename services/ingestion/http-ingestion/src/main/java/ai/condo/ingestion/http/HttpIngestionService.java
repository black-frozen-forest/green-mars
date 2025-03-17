package ai.condo.ingestion.http;

import ai.condo.kafka.KafkaEventPublisher;
import ai.condo.kafka.KafkaProducerAutoConfiguration;
import ai.condo.proto.Detection;
import ai.condo.proto.DetectionBatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootApplication
@Import(KafkaProducerAutoConfiguration.class)
@EnableAutoConfiguration
@RestController
@RequestMapping(value = "/ingest")
public class HttpIngestionService {

    private final KafkaEventPublisher kafkaEventPublisher;

    public HttpIngestionService(@Autowired KafkaEventPublisher kafkaEventPublisher) {
        this.kafkaEventPublisher = kafkaEventPublisher;
    }

    @PostMapping(value = "/detection", consumes = "application/x-protobuf")
    public void ingestDetection(@RequestBody DetectionBatch detectionBatch) {
        kafkaEventPublisher.sendMessage("detection-key", detectionBatch);
    }

    @PostMapping(value = "/detection_json", consumes = "application/json")
    public void ingestDetection(@RequestBody Map<String, Object> jsonPayload) {
        if (!jsonPayload.containsKey("detections")) {
            throw new IllegalArgumentException("Missing 'detections' field");
        }

        List<Map<String, Object>> detectionsList = (List<Map<String, Object>>) jsonPayload.get("detections");
        List<Detection> detections = detectionsList.stream().map(this::mapToDetection).collect(Collectors.toList());

        DetectionBatch detectionBatch = DetectionBatch.newBuilder().addAllDetections(detections).build();
        kafkaEventPublisher.sendMessage("detection-key", detectionBatch);
    }

    private Detection mapToDetection(Map<String, Object> json) {
        return Detection.newBuilder()
                .setTimestamp(((Number) json.get("timestamp")).longValue())
                .setSource((String) json.get("source"))
                .setUniqueId((String) json.get("uniqueId"))
                .setLatitude(((Number) json.get("latitude")).doubleValue())
                .setLongitude(((Number) json.get("longitude")).doubleValue())
                .setType((String) json.get("type"))
                .setConfidence(((Number) json.get("confidence")).floatValue())
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(HttpIngestionService.class, args);
    }
}

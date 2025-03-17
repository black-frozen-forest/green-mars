package ai.condo.ingestion.grpc;

import ai.condo.kafka.KafkaEventPublisher;
import ai.condo.proto.DetectionBatch;
import ai.condo.proto.DetectionServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;

@Service
public class GrpcIngestionService extends DetectionServiceGrpc.DetectionServiceImplBase {

    private final KafkaEventPublisher kafkaEventPublisher;

    public GrpcIngestionService(KafkaEventPublisher kafkaEventPublisher) {
        this.kafkaEventPublisher = kafkaEventPublisher;
    }

    @Override
    public void sendDetection(DetectionBatch request, StreamObserver<DetectionBatch> responseObserver) {
        kafkaEventPublisher.sendMessage("grpc-detection", request);
        responseObserver.onNext(request); // Echo the received data
        responseObserver.onCompleted();
    }
}

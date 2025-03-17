rootProject.name = "ai-condo"

include("common:protobuf")
include("common:kafka-event-publisher-starter")
include("services:ingestion:http-ingestion")
include("services:ingestion:grpc-ingestion")
include("services:ingestion:mqtt-ingestion")
//include("services:processing-service")
//include("services:api-service")
//include("web-ui")


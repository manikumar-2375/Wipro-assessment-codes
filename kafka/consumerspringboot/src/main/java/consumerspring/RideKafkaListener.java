package consumerspring;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RideKafkaListener {

    private final RideRepository repo;
    private final ObjectMapper mapper = new ObjectMapper();

    public RideKafkaListener(RideRepository repo) {
        this.repo = repo;
    }

    @KafkaListener(topics = "${app.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(String message) {
        try {
            JsonNode node = mapper.readTree(message);
            String op = node.get("operation").asText();
            Long id = node.get("id").asLong();

            switch (op) {
                case "CREATE": {
                    Ride r = new Ride();
                    r.setId(id);
                    r.setDriverName(node.path("driverName").asText(null));
                    r.setPassengerName(node.path("passengerName").asText(null));
                    r.setPickupLocation(node.path("pickupLocation").asText(null));
                    r.setDropLocation(node.path("dropLocation").asText(null));
                    r.setFare(node.path("fare").asDouble(0.0));
                    repo.save(r);
                    break;
                }
                case "UPDATE": {
                    Optional<Ride> exist = repo.findById(id);
                    if (exist.isPresent()) {
                        Ride r = exist.get();
                        if (node.has("driverName")) r.setDriverName(node.path("driverName").asText());
                        if (node.has("passengerName")) r.setPassengerName(node.path("passengerName").asText());
                        if (node.has("pickupLocation")) r.setPickupLocation(node.path("pickupLocation").asText());
                        if (node.has("dropLocation")) r.setDropLocation(node.path("dropLocation").asText());
                        if (node.has("fare")) r.setFare(node.path("fare").asDouble());
                        repo.save(r);
                    } else {
                        // If not present, create new
                        Ride r = new Ride();
                        r.setId(id);
                        r.setDriverName(node.path("driverName").asText(null));
                        r.setPassengerName(node.path("passengerName").asText(null));
                        r.setPickupLocation(node.path("pickupLocation").asText(null));
                        r.setDropLocation(node.path("dropLocation").asText(null));
                        r.setFare(node.path("fare").asDouble(0.0));
                        repo.save(r);
                    }
                    break;
                }
                case "DELETE": {
                    repo.deleteById(id);
                    break;
                }
                default:
                    // unknown op
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

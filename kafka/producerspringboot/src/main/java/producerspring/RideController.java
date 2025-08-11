package producerspring;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/rides")
public class RideController {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper mapper = new ObjectMapper();

    @Value("${app.topic.name}")
    private String topic;

    public RideController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public String createRide(@RequestBody RideDto dto) throws Exception {
        Map<String, Object> msg = new HashMap<>();
        msg.put("operation", "CREATE");
        msg.put("id", dto.getId());
        msg.put("driverName", dto.getDriverName());
        msg.put("passengerName", dto.getPassengerName());
        msg.put("pickupLocation", dto.getPickupLocation());
        msg.put("dropLocation", dto.getDropLocation());
        msg.put("fare", dto.getFare());
        kafkaTemplate.send(topic, mapper.writeValueAsString(msg));
        return "CREATE sent";
    }

    @PutMapping("/{id}")
    public String updateRide(@PathVariable Long id, @RequestBody RideDto dto) throws Exception {
        Map<String, Object> msg = new HashMap<>();
        msg.put("operation", "UPDATE");
        msg.put("id", id);
        msg.put("driverName", dto.getDriverName());
        msg.put("passengerName", dto.getPassengerName());
        msg.put("pickupLocation", dto.getPickupLocation());
        msg.put("dropLocation", dto.getDropLocation());
        msg.put("fare", dto.getFare());
        kafkaTemplate.send(topic, mapper.writeValueAsString(msg));
        return "UPDATE sent";
    }

    @DeleteMapping("/{id}")
    public String cancelRide(@PathVariable Long id) throws Exception {
        Map<String, Object> msg = new HashMap<>();
        msg.put("operation", "DELETE");
        msg.put("id", id);
        kafkaTemplate.send(topic, mapper.writeValueAsString(msg));
        return "DELETE sent";
    }

    @GetMapping("/{id}")
    public String getMock(@PathVariable Long id) {
        return "GET is optional on producer side. ID: " + id;
    }
}

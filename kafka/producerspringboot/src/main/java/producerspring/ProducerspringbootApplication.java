package producerspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProducerspringbootApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProducerspringbootApplication.class, args);
    }
}

// C:\kafka_2.13-3.9.0\bin\windows
/*kafka-server-start.bat ..\..\config\server.properties
 * .\zookeeper-server-start.bat ..\..\config\zookeeper.properties
 * .\bin\windows\kafka-topics.bat --create --topic uber-ride-topic --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1


 */

// post http://localhost:8081/rides
// PUT http://localhost:8081/rides/1
//DELETE http://localhost:8081/rides/1
// GET http://localhost:8082/rides




/*{
  "id": 2,
  "driverName": "manikumar darling",
  "passengerName": "dontknow",
  "pickupLocation": "Airport",
  "dropLocation": "hyd",
  "fare": 2440.0
}
{
  "id": 1,
  "driverName": "John Doe",
  "passengerName": "Alice",
  "pickupLocation": "Airport",
  "dropLocation": "Downtown",
  "fare": 250.0
}

*/
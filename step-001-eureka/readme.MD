### Document
When a client registers with Eureka, it provides meta-data about itself — such as host, port, health indicator URL, home page, and other details. Eureka receives heartbeat messages from each instance belonging to a service. If the heartbeat fails over a configurable timetable, the instance is normally removed from the registry.
### Run
    run eureka server
    mvn clean install spring-boot:run

### Eureka server
    monitor: http://localhost:8761
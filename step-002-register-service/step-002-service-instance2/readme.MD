### prerequisites
- Java 8
- maven 3
### ssl certificate
- you should use your hostname instead of hostname in properties.yml
- generate certificate with keytool-command batch file (use commands on Linux OS) in resources of Eureka Server
- locate the client.jks in the resources directory of admin-server project

### execute
    run eureka server
    run admin-server
    mvn clean package spring-boot:run

### actuator
    http://localhost:9092/actuator/info
    http://localhost:9092/actuator/health
    http://localhost:9092/actuator/env

    
### rest
    http://localhost:9092/
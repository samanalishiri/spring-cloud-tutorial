
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
    run hystrix
    mvn clean package spring-boot:run

### hystrix dashboard
    web console: https://localhost:9094/hystrix
    insert url to monitor: https://gf-35436:9093/actuator/hystrix.stream
 
### hystrix rest
    https://localhost:9093/
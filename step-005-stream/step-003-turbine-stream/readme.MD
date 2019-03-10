
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
    run hystrix-dashboard
    run turbine-stream-client
    run turbine-stream
    mvn clean package spring-boot:run

### turbine stream
    web console: https://gf-35436:9094/hystrix
    insert url to monitor: https://gf-35436:9096/turbine.stream?cluster=TURBINE-STREAM-CLIENT
 
### turbine stream client rest
    https://gf-35436:9097/

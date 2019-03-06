### prerequisites
- Java 8
- maven 3
### ssl certificate
- you should use your hostname instead of hostname in properties.yml
- generate certificate with keytool-command batch file (use commands on Linux OS) in resources of Eureka Server
- locate the client.jks in the resources directory of admin-server project

### execute
    1- run eureka server
    2- mvn clean package spring-boot:run

### web console
    https://localhost:9090/

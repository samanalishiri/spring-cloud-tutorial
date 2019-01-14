### Document
When a client registers with Eureka, it provides meta-data about itself — such as host, port, health indicator URL, home page, and other details. Eureka receives heartbeat messages from each instance belonging to a service. If the heartbeat fails over a configurable timetable, the instance is normally removed from the registry.
    
### step one: ssl certificate
open command prompt in resources directory. run follow command:

    keytool -genkey -alias eureka -keyalg RSA -keystore eureka.jks -dname "CN=Saman Alishiri, OU=spring-cloud, O=tutorial, L=Tehran, S=Tehran, C=IR" -storepass 123456 -keypass 123456
    keytool -genkey -alias client -keyalg RSA -keystore client.jks -dname "CN=Saman Alishiri, OU=spring-cloud, O=tutorial, L=Tehran, S=Tehran, C=IR" -storepass 123456 -keypass 123456
    
    keytool -export -alias eureka -file eureka.crt -keystore eureka.jks -storepass 123456
    keytool -export -alias client -file client.crt -keystore client.jks -storepass 123456
    
    keytool -import -alias client -file client.crt -keystore eureka.jks -storepass 123456
    keytool -import -alias eureka -file eureka.crt -keystore client.jks -storepass 123456
    
    keytool -importkeystore -srckeystore client.jks -destkeystore client.p12 -srcstoretype JKS -deststoretype PKCS12 -srcstorepass 123456 -deststorepass 123456 -srcalias client -destalias client -srckeypass 123456 -destkeypass 123456 -noprompt

### step two: run
    mvn clean install spring-boot:run

### step three: eureka server
    monitor: https://localhost:8761

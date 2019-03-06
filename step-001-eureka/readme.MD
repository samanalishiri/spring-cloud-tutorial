### document
When a client registers with Eureka, it provides meta-data about itself — such as host, port, health indicator URL, home page, and other details. Eureka receives heartbeat messages from each instance belonging to a service. If the heartbeat fails over a configurable timetable, the instance is normally removed from the registry.
### prerequisites
- Java 8
- maven 3
### ssl certificate
you should use your hostname instead of hostname in some commands and in properties.yml.

open command prompt in resources directory. run follow command:

   
    When prompted Trust this certificate? [no]:, enter "yes".
    
    keytool -delete -alias eureka -keystore %JAVA_HOME%/jre/lib/security/cacerts -storepass changeit
    keytool -delete -alias client -keystore %JAVA_HOME%/jre/lib/security/cacerts -storepass changeit
   
    keytool -genkey -alias eureka -keyalg RSA -keystore eureka.jks -dname "CN=Saman Alishiri, OU=spring-cloud, O=tutorial, L=Tehran, S=Tehran, C=IR" -ext "SAN:c=DNS:hostname,IP:127.0.0.1" -storepass 123456 -keypass 123456
    keytool -genkey -alias client -keyalg RSA -keystore client.jks -dname "CN=client-app, OU=spring-cloud, O=tutorial, L=Tehran, S=Tehran, C=IR" -ext "SAN:c=DNS:hostname,IP:127.0.0.1" -storepass 123456 -keypass 123456
    
    keytool -export -alias eureka -file eureka.crt -keystore eureka.jks -storepass 123456
    keytool -export -alias client -file client.crt -keystore client.jks -storepass 123456
    
    keytool -import -alias client -file client.crt -keystore eureka.jks -storepass 123456
    keytool -import -alias eureka -file eureka.crt -keystore client.jks -storepass 123456
    
    keytool -importkeystore -srckeystore client.jks -destkeystore client.p12 -srcstoretype JKS -deststoretype PKCS12 -srcstorepass 123456 -deststorepass 123456 -srcalias client -destalias client -srckeypass 123456 -destkeypass 123456 -noprompt
    
    keytool -import -trustcacerts -alias client -file client.crt -keystore %JAVA_HOME%/jre/lib/security/cacerts -storepass changeit
    keytool -import -trustcacerts -alias eureka -file eureka.crt -keystore %JAVA_HOME%/jre/lib/security/cacerts -storepass changeit
   


### execute
    mvn clean package spring-boot:run

### web console
    https://localhost:443/

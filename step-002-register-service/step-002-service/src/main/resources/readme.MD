### run
    run eureka server
    run step-002-service

###eureka server
    monitor: http://localhost:8761

###actuator
    http://localhost:9090/monitoring/info
    http://localhost:9090/monitoring/health
    http://localhost:9090/monitoring/env
    ...
    
###rest
    http://localhost:{step-002-service-port}/step002/hello
package com.saman.tutorial.springcloud.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class HealthCheck implements HealthIndicator {

    int errorCode = 0;

    @Override
    public Health health() {
        log();

        Health health = isFailed() ? down() : up();
        errorCode++;

        return health;
    }

    private boolean isFailed() {
        return errorCode > 5 && errorCode < 15;
    }

    private Health up() {
        return Health.up().build();
    }

    private Health down() {
        errorCode++;
        return Health.down().withDetail("Error Code", errorCode).build();
    }

    private void log() {
        System.out.println("errorCode = " + errorCode);
    }
}

package test.pivotal.pal.tracker;

import io.pivotal.pal.tracker.TimeEntryRepository;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * Created by tiwang on 11/15/18.
 */
@Component
public class TimeEntryHealthIndicator implements HealthIndicator{
    
    private TimeEntryRepository store;

    @Override
    public Health health() {
        return null;
    }
}

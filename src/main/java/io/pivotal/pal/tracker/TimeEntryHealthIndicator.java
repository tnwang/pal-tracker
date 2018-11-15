package io.pivotal.pal.tracker;

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

    public TimeEntryHealthIndicator(TimeEntryRepository store) {
        this.store = store;
    }

    @Override
    public Health health() {
        Health.Builder builder = new Health.Builder();

        if(store.list().size() < 5) {
            builder.up();
        } else {
            builder.down();
        }

        return builder.build();
    }
}

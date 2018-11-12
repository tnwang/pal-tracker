package io.pivotal.pal.tracker;

import java.util.List;

/**
 * Created by tiwang on 11/11/18.
 */
public interface TimeEntryRepository {

    TimeEntry create(TimeEntry entry);

    TimeEntry find(long id);

    List<TimeEntry> list();

    TimeEntry update(long id, TimeEntry entry);

    void delete(long id);

}

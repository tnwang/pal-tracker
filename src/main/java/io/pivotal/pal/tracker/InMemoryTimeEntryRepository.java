package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tiwang on 11/11/18.
 */
public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private Map<Long, TimeEntry> store = new HashMap<Long, TimeEntry>();
    private long id = 1L;

    public TimeEntry create(TimeEntry entry){
        long newId = id;
        id++;
        entry.setId(newId);
        store.put(entry.getId(), entry);
        return store.get(newId);
    }

    public TimeEntry find(long id) {
        return store.get(id);
    }

    public List<TimeEntry> list() {
        return new ArrayList<>(store.values());
    }

    public TimeEntry update(long id, TimeEntry entry){
        if (find(id)== null) return null;
        entry.setId(id);
        store.put(id, entry);
        return store.get(id);
    }

    public void delete(long id){
        store.remove(id);
    }
}

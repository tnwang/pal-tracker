package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by tiwang on 11/11/18.
 */
@RestController
public class TimeEntryController {

    private TimeEntryRepository store;

    public TimeEntryController(TimeEntryRepository store) {
        this.store = store;
    }

    @RequestMapping(path="/time-entries", method = POST)
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry entry){
        TimeEntry response = store.create(entry);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @RequestMapping(path="/time-entries/{id}", method = GET)
    public ResponseEntity<TimeEntry> read(@PathVariable("id")long timeEntryId){
        TimeEntry result = store.find(timeEntryId);
        if (result == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(path="/time-entries", method = GET)
    public ResponseEntity<List<TimeEntry>> list(){
        return new ResponseEntity<>(store.list(), HttpStatus.OK);
    }

    @RequestMapping(path="/time-entries/{id}", method = PUT)
    public ResponseEntity<TimeEntry> update(@PathVariable("id") long timeEntryId, @RequestBody TimeEntry entry){
        TimeEntry result = store.update(timeEntryId, entry);
        if (result == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(path="/time-entries/{id}", method = DELETE)
    public ResponseEntity<TimeEntry> delete(@PathVariable("id") long timeEntryId){
        store.delete(timeEntryId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

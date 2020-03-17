package io.pivotal.pal.tracker;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TimeEntryRepository {

    public TimeEntry create(TimeEntry timeEntryToCreate);

    public TimeEntry update(long timeEntryId, TimeEntry timeEntry);

    public void delete(long timeEntryId);

    public TimeEntry find(long timeEntryId);

    public List<TimeEntry> list();
}

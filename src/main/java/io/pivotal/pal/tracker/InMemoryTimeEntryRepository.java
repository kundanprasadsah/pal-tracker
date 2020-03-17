package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements  TimeEntryRepository {

    public long timeEntryIdCounter = 1L;
    public Map<Long, TimeEntry> timeEntryMap = new HashMap<>();

    public TimeEntry create(TimeEntry timeEntryToCreate){
        TimeEntry newTimeEntryRecord = new TimeEntry(timeEntryIdCounter, timeEntryToCreate.getProjectId(),
                timeEntryToCreate.getUserId(), timeEntryToCreate.getDate(), timeEntryToCreate.getHours());

        timeEntryMap.put(timeEntryIdCounter, newTimeEntryRecord);

        timeEntryIdCounter = timeEntryIdCounter + 1L;

        return timeEntryMap.get(timeEntryIdCounter-1L);
    }

    public TimeEntry update(long timeEntryId, TimeEntry timeEntry){

        TimeEntry newTimeEntryRecord = new TimeEntry(timeEntryId, timeEntry.getProjectId(),
                timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());

        if ( timeEntryMap.containsKey(timeEntryId)) {
            timeEntryMap.put(timeEntryId, newTimeEntryRecord);
            return timeEntryMap.get(timeEntryId);
        }
        return null;
    }

    public void delete(long timeEntryId){
       timeEntryMap.remove(timeEntryId);
    }

    public TimeEntry find(long timeEntryId){

        return timeEntryMap.get(timeEntryId);
    }

    public List<TimeEntry> list(){
        return new ArrayList<>(timeEntryMap.values());
    }
}

package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TimeEntryController {

    private TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository){
        this.timeEntryRepository =  timeEntryRepository;
    }

    @PostMapping("/time-entries")
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntryToCreate){

        TimeEntry createdTimeEntry = this.timeEntryRepository.create(timeEntryToCreate);

        return  ResponseEntity.status(HttpStatus.CREATED).body(createdTimeEntry);
    }

    @PutMapping("/time-entries/{id}")
    public ResponseEntity<TimeEntry> update(@PathVariable(name = "id") long timeEntryId, @RequestBody TimeEntry timeEntry){

        TimeEntry updatedTimeEntry = this.timeEntryRepository.update(timeEntryId, timeEntry);

        if ( updatedTimeEntry != null ) {
            return ResponseEntity.ok(updatedTimeEntry);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/time-entries/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable(name = "id") long timeEntryId){

        this.timeEntryRepository.delete(timeEntryId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/time-entries/{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable (name = "id") long timeEntryId){
        TimeEntry fetchedTimeEntry = this.timeEntryRepository.find(timeEntryId);
        if ( fetchedTimeEntry != null ) {
            return ResponseEntity.ok(fetchedTimeEntry);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/time-entries")
    public ResponseEntity<List<TimeEntry>> list(){

        List<TimeEntry> timeEntryList = this.timeEntryRepository.list();

        return ResponseEntity.ok(timeEntryList);
    }
}

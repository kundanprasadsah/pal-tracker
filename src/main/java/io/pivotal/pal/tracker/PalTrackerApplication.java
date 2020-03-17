package io.pivotal.pal.tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PalTrackerApplication {

    public static void main(String[] arg){

        SpringApplication.run(PalTrackerApplication.class, arg);

    }

    @Bean
    public TimeEntryRepository inMemoryTimeEntryRepository(){
        return new InMemoryTimeEntryRepository();
    }
}

package io.pivotal.pal.tracker;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.TimeZone;

@SpringBootApplication
public class PalTrackerApplication {

    public static void main(String[] arg){

        SpringApplication.run(PalTrackerApplication.class, arg);

    }

    @Bean
    public TimeEntryRepository jdbcTimeEntryRepository(){

        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl(System.getenv("SPRING_DATASOURCE_URL"));

        return new JdbcTimeEntryRepository(dataSource);
    }
}

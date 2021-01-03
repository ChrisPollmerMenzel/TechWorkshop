package de.techworkshop.mongo.config;

import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.context.TestPropertySource;

@DataMongoTest
@EnableMongoAuditing
@ComponentScan("de.techworkshop")
@EnableMongoRepositories({"de.techworkshop.mongo.repository"})
@Configuration
public class UnitTestConfiguration {
}

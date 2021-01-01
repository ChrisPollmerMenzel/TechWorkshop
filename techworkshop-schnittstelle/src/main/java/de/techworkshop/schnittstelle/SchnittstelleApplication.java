package de.techworkshop.schnittstelle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("de.techworkshop")
public class SchnittstelleApplication {

  public static void main(String[] args) {
    SpringApplication.run(SchnittstelleApplication.class, args);
  }

}

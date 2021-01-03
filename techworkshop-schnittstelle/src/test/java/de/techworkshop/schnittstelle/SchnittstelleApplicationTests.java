package de.techworkshop.schnittstelle;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SchnittstelleApplication.class)
class SchnittstelleApplicationTests {

  @LocalServerPort
  int port;

  @Test
  void testInit() {

    String apiContract = "http://localhost:8081/v2/api-docs";
    System.out.println(apiContract);
    String swaggerSchemaUrl = String.format("http://localhost:%d/v2/api-docs", port);
    assertEquals(apiContract, swaggerSchemaUrl);
  }
}

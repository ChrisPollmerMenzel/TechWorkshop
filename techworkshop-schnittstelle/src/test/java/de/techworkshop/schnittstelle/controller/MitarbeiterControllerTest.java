package de.techworkshop.schnittstelle.controller;

import de.techworkshop.mongo.document.MitarbeiterDocument;
import de.techworkshop.mongo.service.MitarbeiterServiceImpl;
import de.techworkshop.schnittstelle.SchnittstelleApplication;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test des Mitarbeiter REST Endpunkts.
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class MitarbeiterControllerTest {

  @LocalServerPort
  private int port;

  @MockBean
  private MitarbeiterServiceImpl mitarbeiterService;

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  void testFindAllMitarbeiter() {

    MitarbeiterDocument mitarbeiterDocument = new MitarbeiterDocument(UUID.randomUUID(), "", "");
    List<MitarbeiterDocument> mitarbeiterList = new ArrayList<>();
    mitarbeiterList.add(mitarbeiterDocument);

    Mockito.when(this.mitarbeiterService.findAll()).thenReturn(mitarbeiterList);

    List<MitarbeiterDocument> mitarbeiterDocumentList = this.restTemplate
        .getForObject("http://localhost:" + port + "/mitarbeiter/all", ArrayList.class);

    assertEquals(1, mitarbeiterDocumentList.size());
  }
}
package de.techworkshop.mongo.service;

import de.techworkshop.mongo.config.UnitTestConfiguration;
import de.techworkshop.mongo.document.MitarbeiterDocument;
import de.techworkshop.mongo.repository.MitarbeiterRepository;
import de.techworkshop.mongo.utils.MitarbeiterUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test Klasse für {@link MitarbeiterService}.
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@ContextConfiguration(classes = {UnitTestConfiguration.class})
class MitarbeiterServiceImplTest {

  /**
   * Mocked repository {@link MitarbeiterRepository}.
   */
  @MockBean
  @Autowired
  private MitarbeiterRepository mitarbeiterRepository;

  /**
   * {@link MitarbeiterServiceImpl}.
   */
  @Autowired
  private MitarbeiterServiceImpl mitarbeiterService;

  @Test
  void testFindAll() {

    final UUID uuid = UUID.randomUUID();

    MitarbeiterDocument mitarbeiterDocument = MitarbeiterUtils.createMitarbeiterDocument(uuid);
    List<MitarbeiterDocument> mitarbeiterDocumentList = new ArrayList<>();
    mitarbeiterDocumentList.add(mitarbeiterDocument);

    Mockito.when(this.mitarbeiterRepository.findAll()).thenReturn(mitarbeiterDocumentList);

    List<MitarbeiterDocument> resultList = this.mitarbeiterService.findAll();

    assertNotNull(resultList);
    assertEquals(1, resultList.size());
    assertEquals(uuid, resultList.get(0).getUuid());
    assertEquals(mitarbeiterDocument.getFirstName(), resultList.get(0).getFirstName());
    assertEquals(mitarbeiterDocument.getLastName(), resultList.get(0).getLastName());
  }

  @Test
  void testFindAllByFirstName() {

    final UUID uuid = UUID.randomUUID();

    MitarbeiterDocument mitarbeiterDocument = MitarbeiterUtils.createMitarbeiterDocument(uuid);
    List<MitarbeiterDocument> mitarbeiterDocumentList = new ArrayList<>();
    mitarbeiterDocumentList.add(mitarbeiterDocument);

    Mockito.when(this.mitarbeiterRepository.findAllByFirstName(mitarbeiterDocument.getFirstName()))
        .thenReturn(mitarbeiterDocumentList);

    List<MitarbeiterDocument> resultList = this.mitarbeiterService
        .findAllByFirstName(mitarbeiterDocument.getFirstName());

    assertNotNull(resultList);
    assertEquals(1, resultList.size());
    assertEquals(uuid, resultList.get(0).getUuid());
    assertEquals(mitarbeiterDocument.getFirstName(), resultList.get(0).getFirstName());
    assertEquals(mitarbeiterDocument.getLastName(), resultList.get(0).getLastName());
  }

  @Test
  void testFindByUserName() {

    final UUID uuid = UUID.randomUUID();

    MitarbeiterDocument mitarbeiterDocument = MitarbeiterUtils.createMitarbeiterDocument(uuid);

    Mockito.when(this.mitarbeiterRepository.findByUserName(mitarbeiterDocument.getUserName()))
        .thenReturn(mitarbeiterDocument);

    MitarbeiterDocument result = this.mitarbeiterService
        .findByUserName(mitarbeiterDocument.getUserName());

    assertNotNull(result);
    assertEquals(uuid, result.getUuid());
    assertEquals(mitarbeiterDocument.getFirstName(), result.getFirstName());
    assertEquals(mitarbeiterDocument.getLastName(), result.getLastName());
    assertEquals(mitarbeiterDocument.getUserName(), result.getUserName());
  }
}
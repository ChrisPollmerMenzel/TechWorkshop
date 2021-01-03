package de.techworkshop.mongo.repository;

import de.techworkshop.mongo.config.UnitTestConfiguration;
import de.techworkshop.mongo.document.MitarbeiterDocument;
import de.techworkshop.mongo.utils.AbstractRepositoryTest;
import de.techworkshop.mongo.utils.MitarbeiterMongoRepositoryInitializer;
import de.techworkshop.mongo.utils.MitarbeiterUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Repository tests für {@link MitarbeiterRepository}.
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@ContextConfiguration(classes = {UnitTestConfiguration.class})
class MitarbeiterRepositoryTest extends
    AbstractRepositoryTest<MitarbeiterRepository, MitarbeiterDocument, ObjectId> {

  /**
   * {@link List} von {@link UUID}.
   */
  private final List<UUID> uuidList = new ArrayList<>();

  /**
   * Initializer für MongoRepository.
   */
  @Autowired
  private MitarbeiterMongoRepositoryInitializer mongoRepositoryInitializer;

  /**
   * Datenbank einrichten mit Werten.
   */
  @BeforeEach
  @Override
  public void setUp() {

    this.uuidList.add(UUID.randomUUID());
    this.uuidList.add(UUID.randomUUID());
    this.uuidList.add(UUID.randomUUID());

    assertNotNull(this.mongoRepositoryInitializer);

    dropDatabase();

    this.mongoRepositoryInitializer.setUuidList(this.uuidList);
    this.mongoRepositoryInitializer.initRepository();

    super.setUp();
  }

  /**
   * Datenbank herunterfahren/löschen.
   */
  @AfterEach
  @Override
  public void tearDown() {

    this.mongoRepositoryInitializer.dropMongoCollection();

    dropDatabase();

    super.tearDown();
  }

  @Test
  void testFindAll() {

    List<MitarbeiterDocument> resultList = this.repository.findAll();

    assertNotNull(resultList);
    assertEquals(3, resultList.size());
  }

  @Test
  void testSave() {

    final UUID uuid = UUID.randomUUID();

    MitarbeiterDocument mitarbeiterDocument = new MitarbeiterDocument(uuid, "Tom", "H");

    this.repository.save(mitarbeiterDocument);

    List<MitarbeiterDocument> resultList = this.repository
        .findAllByFirstName(mitarbeiterDocument.getFirstName());

    assertNotNull(resultList);
    assertEquals(1, resultList.size());
    assertEquals(uuid, resultList.get(0).getUuid());
    assertEquals(mitarbeiterDocument.getFirstName(), resultList.get(0).getFirstName());
    assertEquals(mitarbeiterDocument.getLastName(), resultList.get(0).getLastName());
  }

  @Test
  void testFindAllByFirstName() {

    MitarbeiterDocument mitarbeiterDocument = MitarbeiterUtils.createMitarbeiterDocument();

    List<MitarbeiterDocument> resultList = this.repository
        .findAllByFirstName(mitarbeiterDocument.getFirstName());

    assertNotNull(resultList);
    assertEquals(3, resultList.size());
    assertEquals(mitarbeiterDocument.getFirstName(), resultList.get(0).getFirstName());
    assertEquals(mitarbeiterDocument.getLastName(), resultList.get(0).getLastName());
  }
}
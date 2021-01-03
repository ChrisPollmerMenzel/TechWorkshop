package de.techworkshop.mongo.utils;

import de.techworkshop.mongo.document.MitarbeiterDocument;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;
import org.apache.commons.collections4.CollectionUtils;
import static org.springframework.test.util.AssertionErrors.assertTrue;

/**
 * Initializer zum test von {@link MitarbeiterDocument}.
 */
@Component
public class MitarbeiterMongoRepositoryInitializer extends
    AbstractMongoRepositoryInitializer<MitarbeiterDocument> {

  /**
   * Liste von {@link UUID}.
   */
  private final List<UUID> uuidList = new ArrayList<>();

  /**
   * Erzeugt ein {@link MitarbeiterMongoRepositoryInitializer}.
   *
   * @param mongoOperations {@link MongoOperations}.
   */
  @Autowired
  public MitarbeiterMongoRepositoryInitializer(MongoOperations mongoOperations) {

    super(mongoOperations);
  }

  @Override
  protected Class<MitarbeiterDocument> getMongoCollectionClass() {

    return MitarbeiterDocument.class;
  }

  @Override
  protected MitarbeiterDocument createMongoEntityInstance() {

    return MitarbeiterUtils.createMitarbeiterDocument();
  }

  @Override
  public void initRepository() {

    dropMongoCollection();

    assertTrue("keine UUIDs gesetzt!", CollectionUtils.isNotEmpty(this.uuidList));

    for (UUID uuid : this.uuidList) {

      MitarbeiterDocument document = MitarbeiterUtils.createMitarbeiterDocument(uuid);

      getMongoOperations().save(document);

    }

  }

  /**
   * Setzt die Liste von {@link UUID}.
   *
   * @param uuidList Liste von {@link UUID}
   */
  public void setUuidList(List<UUID> uuidList) {

    this.uuidList.clear();
    this.uuidList.addAll(uuidList);
  }
}

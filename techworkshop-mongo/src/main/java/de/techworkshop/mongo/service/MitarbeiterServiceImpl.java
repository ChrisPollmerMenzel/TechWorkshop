package de.techworkshop.mongo.service;

import de.techworkshop.mongo.core.AbstractMongoRepositoryServiceImpl;
import de.techworkshop.mongo.document.MitarbeiterDocument;
import de.techworkshop.mongo.factory.MitarbeiterFactory;
import de.techworkshop.mongo.repository.MitarbeiterRepository;
import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 * Implementierung von {@link MitarbeiterService}.
 */
@Service
public class MitarbeiterServiceImpl extends AbstractMongoRepositoryServiceImpl<MitarbeiterRepository, MitarbeiterDocument, ObjectId> implements MitarbeiterService {

  /**
   * {@link MitarbeiterFactory}
   */
  private final MitarbeiterFactory factory;

  protected MitarbeiterServiceImpl(
      MongoTemplate mongoTemplate,
      MitarbeiterRepository mongoRepository,
      MitarbeiterFactory factory) {
    super(mongoTemplate, mongoRepository, MitarbeiterDocument.class);
    this.factory = factory;
  }

  @Override
  public MitarbeiterDocument save(MitarbeiterDocument mitarbeiterDocument) {

    if (Objects.isNull(mitarbeiterDocument.getUuid())) {
      mitarbeiterDocument = this.factory.newMitarbeiter(mitarbeiterDocument);
    }

    return Objects.nonNull(mitarbeiterDocument) ? super.save(mitarbeiterDocument) : null;
  }

  @Override
  public List<MitarbeiterDocument> findAll() {
    return this.getMongoRepository().findAll();
  }

  @Override
  public List<MitarbeiterDocument> findAllByFirstName(String firstName) {
    return this.getMongoRepository().findAllByFirstName(firstName);
  }
}

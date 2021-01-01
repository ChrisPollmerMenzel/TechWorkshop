package de.techworkshop.mongo.service;

import de.techworkshop.mongo.document.MitarbeiterDocument;
import de.techworkshop.mongo.core.MongoRepositoryService;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Service für die Verabeitung von {@link MitarbeiterDocument}.
 */
public interface MitarbeiterService extends MongoRepositoryService<MitarbeiterDocument, ObjectId> {

  /**
   * Speichern.
   *
   * @param mitarbeiterDocument {@link MitarbeiterDocument}
   * @return {@link MitarbeiterDocument}
   */
  MitarbeiterDocument save(MitarbeiterDocument mitarbeiterDocument);

  /**
   * Suchen nachen allen Datenbankeinträgen.
   *
   * @return {@link List} von {@link MitarbeiterDocument}
   */
  List<MitarbeiterDocument> findAll();

  /**
   * Suche nach allen Datensätzen mit dem firstName.
   *
   * @param firstName Vorname
   * @return {@link List} von {@link MitarbeiterDocument}
   */
  List<MitarbeiterDocument> findAllByFirstName(String firstName);
}

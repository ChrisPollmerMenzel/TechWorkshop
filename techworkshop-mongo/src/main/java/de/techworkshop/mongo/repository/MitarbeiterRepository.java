package de.techworkshop.mongo.repository;

import de.techworkshop.mongo.document.MitarbeiterDocument;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public interface MitarbeiterRepository extends MongoRepository<MitarbeiterDocument, ObjectId> {

  List<MitarbeiterDocument> findAll();

  List<MitarbeiterDocument> findAllByFirstName(String firstName);
}

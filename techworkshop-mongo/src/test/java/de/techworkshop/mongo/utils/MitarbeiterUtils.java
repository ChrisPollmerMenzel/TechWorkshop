package de.techworkshop.mongo.utils;

import de.techworkshop.mongo.document.MitarbeiterDocument;
import java.util.UUID;

/**
 * Utility Klasse für {@link MitarbeiterDocument}.
 */
public class MitarbeiterUtils {

  public static MitarbeiterDocument createMitarbeiterDocument() {

    return createMitarbeiterDocument(UUID.randomUUID());
  }

  public static MitarbeiterDocument createMitarbeiterDocument(UUID uuid) {

    String firstName = "Tim";
    String lastName = "Hoffmann";
    String userName = "TimH";

    return new MitarbeiterDocument(uuid, firstName, lastName, userName);
  }

}

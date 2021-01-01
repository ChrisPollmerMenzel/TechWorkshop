package de.techworkshop.mongo.factory;

import de.techworkshop.mongo.document.MitarbeiterDocument;
import java.util.Objects;
import java.util.UUID;
import org.springframework.stereotype.Component;

/**
 * Factory für {@link MitarbeiterDocument}.
 */
@Component
public class MitarbeiterFactory {

  /**
   * Erstellt eine Instanz von {@link MitarbeiterDocument}.
   *
   * @param mitarbeiterDocument {@link MitarbeiterDocument}
   *
   * @return new {@link MitarbeiterDocument}
   */
  public MitarbeiterDocument newMitarbeiter(MitarbeiterDocument mitarbeiterDocument) {
    MitarbeiterDocument mitarbeiter = null;

    if (Objects.nonNull(mitarbeiterDocument)) {
      mitarbeiter = new MitarbeiterDocument(UUID.randomUUID(), mitarbeiterDocument.getFirstName(),
          mitarbeiterDocument.getLastName());
    }

    return mitarbeiter;
  }

}

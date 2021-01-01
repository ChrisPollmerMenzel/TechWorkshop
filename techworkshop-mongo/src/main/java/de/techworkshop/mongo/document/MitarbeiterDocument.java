package de.techworkshop.mongo.document;

import de.techworkshop.mongo.core.AbstractDocument;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Mitarbeiter")
public class MitarbeiterDocument extends AbstractDocument<ObjectId> {

  private static final long serialVersionUID = -399464903589153154L;

  /**
   * {@link UUID}.
   */
  @NonNull
  @Getter
  @Setter
  @Indexed
  private UUID uuid;

  /**
   * Vorname.
   */
  @Setter
  @Getter
  @NonNull
  private String firstName;

  /**
   * Nachname.
   */
  @Setter
  @Getter
  @NonNull
  private String lastName;
}

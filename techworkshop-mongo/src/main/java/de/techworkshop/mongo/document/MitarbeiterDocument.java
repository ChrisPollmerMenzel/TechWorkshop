package de.techworkshop.mongo.document;

import de.techworkshop.mongo.core.AbstractDocument;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@ApiModel(description = "Zeigt die Werte eines Mitarbeiters.")
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
  @ApiModelProperty(notes = "Eindeutige ID.")
  private UUID uuid;

  /**
   * Vorname.
   */
  @Setter
  @Getter
  @NonNull
  @ApiModelProperty(notes = "Vorname")
  private String firstName;

  /**
   * Nachname.
   */
  @Setter
  @Getter
  @NonNull
  @ApiModelProperty(notes = "Nachname")
  private String lastName;

  /**
   * Benutzername.
   */
  @Setter
  @Getter
  @NonNull
  @ApiModelProperty(notes = "Benutzername")
  private String userName;
}

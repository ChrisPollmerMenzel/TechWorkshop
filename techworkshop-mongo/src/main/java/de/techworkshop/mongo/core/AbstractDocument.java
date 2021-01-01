package de.techworkshop.mongo.core;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;

public abstract class AbstractDocument<IdT extends Serializable> implements Persistable<IdT>,
    Serializable {

  private static final long serialVersionUID = 1730645414932215577L;
  @Id
  private IdT id;

  public AbstractDocument() {
  }

  public IdT getId() {
    return this.id;
  }

  protected void setId(final IdT id) {
    this.id = id;
  }

  public boolean isNew() {
    return null == this.getId();
  }

  /**
   * Methode für den Hashcode.
   */
  public int hashCode() {
    return this.id == null ? 0 : this.id.hashCode();
  }

  /**
   * Equals für Documents.
   */
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    } else if (this.id != null && obj != null && this.getClass().equals(obj.getClass())) {
      AbstractDocument<?> that = (AbstractDocument) obj;
      return this.id.equals(that.getId());
    } else {
      return false;
    }
  }
}

package de.techworkshop.mongo.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.util.Assert;

public abstract class AbstractMongoRepositoryInitializer<T> {

  private final MongoOperations mongoOperations;

  protected AbstractMongoRepositoryInitializer(MongoOperations mongoOperations) {
    Assert.notNull(mongoOperations, "'mongoOperations' muss gesetzt sein!");
    this.mongoOperations = mongoOperations;
  }

  protected abstract Class<T> getMongoCollectionClass();

  protected abstract T createMongoEntityInstance();

  public abstract void initRepository();

  public void dropMongoCollection() {
    this.mongoOperations.indexOps(this.getMongoCollectionClass()).dropAllIndexes();
    this.mongoOperations.dropCollection(this.getMongoCollectionClass());
  }

  /**
   * MongoEntity.
   */
  public <D> T createMongoEntity(D domainObject) {
    T result = null;
    if (domainObject != null) {
      result = this.createMongoEntityInstance();
      BeanUtils.copyProperties(domainObject, result);
    }

    return result;
  }

  protected MongoOperations getMongoOperations() {
    return this.mongoOperations;
  }
}

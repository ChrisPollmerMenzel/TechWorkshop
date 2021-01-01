package de.techworkshop.mongo.core;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Persistable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;

public abstract class AbstractMongoRepositoryServiceImpl<R extends MongoRepository<T, IdT>, T extends Persistable<IdT>, IdT extends Serializable> implements
    MongoRepositoryService<T, IdT> {

  private final MongoTemplate mongoTemplate;
  private final R mongoRepository;
  private final Class<T> classType;

  protected AbstractMongoRepositoryServiceImpl(MongoTemplate mongoTemplate, R mongoRepository,
      Class<T> classType) {
    this.mongoTemplate = mongoTemplate;
    this.mongoRepository = mongoRepository;
    this.classType = classType;
  }

  public <S extends T> S save(S objectToSave) {
    return objectToSave != null ? (S) this.getMongoRepository().save(objectToSave) : null;
  }

  /**
   * Delete by Id.
   */
  public void deleteById(IdT id) {
    if (id != null) {
      this.getMongoRepository().deleteById(id);
    }

  }

  /**
   * Delete Document.
   */
  public void delete(T entity) {
    if (entity != null) {
      this.getMongoRepository().delete(entity);
    }

  }

  public void deleteAll() {
    this.mongoTemplate.dropCollection(this.classType);
  }

  public long count() {
    return this.getMongoRepository().count();
  }

  public Optional<T> findById(IdT id) {
    return this.getMongoRepository().findById(id);
  }

  public List<T> findAll() {
    return this.getMongoRepository().findAll();
  }

  protected MongoTemplate getMongoTemplate() {
    return this.mongoTemplate;
  }

  protected R getMongoRepository() {
    return this.mongoRepository;
  }

  protected Class<T> getClassType() {
    return this.classType;
  }
}


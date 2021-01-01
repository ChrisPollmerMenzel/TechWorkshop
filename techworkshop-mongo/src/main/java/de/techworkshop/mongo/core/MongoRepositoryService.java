package de.techworkshop.mongo.core;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Persistable;

public interface MongoRepositoryService<T extends Persistable<IdT>, IdT extends Serializable> {

  <S extends T> S save(S objectToSave);

  void deleteById(IdT id);

  void delete(T entity);

  void deleteAll();

  long count();

  Optional<T> findById(IdT id);

  List<T> findAll();
}

package de.techworkshop.mongo.utils;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.Serializable;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Klasse zum Testen von Repositorys.
 *
 * @param <R> Repository
 * @param <T> Documentklasse
 * @param <IdT> Id des Document
 */
public abstract class AbstractRepositoryTest<R extends MongoRepository<T, IdT>, T, IdT extends Serializable> {

  /**
   * {@link MongoTemplate}.
   */
  @Autowired
  private MongoTemplate mongoTemplate;

  /**
   * Repository.
   */
  @Autowired
  protected R repository;

  /**
   * Repository Count.
   */
  protected long maxCount;

  /**
   * Konstruktor.
   */
  public AbstractRepositoryTest() {
  }

  /**
   * Start Testumgebung.
   */
  @BeforeEach
  public void setUp() {
    assertNotNull(this.mongoTemplate);
    assertNotNull(this.repository);
    this.maxCount = this.repository.count();
  }

  /**
   * End Testumgebung.
   */
  @AfterEach
  public void tearDown() {
    this.dropDatabase();
  }

  /**
   * Datenbank löschen.
   */
  protected void dropDatabase() {
    assertNotNull(this.mongoTemplate);
    this.mongoTemplate.getDb().drop();
  }

}

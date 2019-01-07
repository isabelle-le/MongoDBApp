package mongo.movies.spring.configuration;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
/**
 * create by Huong and Nepes 6.1.2019
 */
@Configuration
public class MongoDBConfig extends AbstractMongoConfiguration {
  @Override
  public MongoClient mongoClient() {
    // Change it with the one coming from application.properties.
    return new MongoClient("127.0.0.1", 27017);
  }

  @Override
  protected String getDatabaseName() {
    // Return the database name
    return "movies";
  }
}

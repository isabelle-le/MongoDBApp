package mongo.movies.spring.repository;

import mongo.movies.spring.domain.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RatingRepository extends MongoRepository<Rating, String> {}

package mongo.movies.spring.bootstrap;

import mongo.movies.spring.domain.Movie;
import mongo.movies.spring.domain.Rating;
import mongo.movies.spring.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * create by Huong and Nepes 6.1.2019
 */
@Component
public class BootstrapData implements CommandLineRunner {
  @Autowired
  private MovieRepository movieRepository;

  @Override
  public void run(String... args) throws Exception {
    List<Movie> movies = movieRepository.findAll();
    for (Movie movie : movies) {
      Random random = new Random();
      List<Rating> ratings = new ArrayList<Rating>();
      for (int i = 0; i < (random.nextInt(50) + 10); i++) {
        Rating rating = new Rating();
        rating.setRating(1 + (random.nextDouble() * (10-1)));
        ratings.add(rating);
      }
      movie.setRatings(ratings);
      movieRepository.save(movie);
    }
  }
}

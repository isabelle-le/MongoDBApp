package mongo.movies.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

// import java.time.Duration;
import java.time.Duration;
import java.util.List;
/**
 * create by Huong and Nepes 6.1.2019
 */
@Data
@Document(value = "spring")
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
  @Id
  public String _id;
  private String title;
  private Integer year;

  public Duration getDuration() {
    if (this.runtime != null) {
      return Duration.ofMinutes(this.runtime);
    }
    return Duration.ofMinutes(0);
  }

  private Integer runtime;

  private List<String> genres;

  private List<Rating> ratings;
}

package mongo.movies.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
/**
 * create by Huong and Nepes 6.1.2019
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "ratings")
public class Rating {
  @Id
  public String _id;

  @DecimalMax(message = "Rating could not be larger than 10", value = "10")
  @DecimalMin(message = "Rating could not be less than 1", value = "1")
  private Double rating;

  @Transient
  private Integer votes;
}

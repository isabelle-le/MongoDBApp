package mongo.movies.spring.controller;

import mongo.movies.spring.domain.Movie;
import mongo.movies.spring.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
/**
 * create by Huong and Nepes 6.1.2019
 */
@Controller
@RequestMapping(value = IndexController.URL)
public class IndexController {
  public static final String URL = "";

  @Autowired private MovieRepository movieRepository;

  // MARK: API get all films
  @RequestMapping(value = "/api/films", method = RequestMethod.GET)
  public List<Movie> getAllFilms() {
    return movieRepository.findAll();
  }

  // MovieList
  @RequestMapping(
      value = {"/", "", "/MovieList"},
      method = RequestMethod.GET)
  public String filmsList(Model model) {
    model.addAttribute("movies", movieRepository.findAll());
    return "MovieList";
  }

  // DeleteMovie
  @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
  public String deleteUser(@PathVariable("id") String id, Model model) {
    Movie movie = movieRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
    movieRepository.delete(movie);

    model.addAttribute("movies", movieRepository.findAll());
    return "MovieList";
  }

  // AddMovie
  @RequestMapping("/addMovie")
  public String addMovie(Movie movie) {
    return "addMovie";
  }

  @RequestMapping(value = "/addMovie", method = RequestMethod.POST)
  public String addMovie(@Valid Movie movie, BindingResult result, Model model) {
    if (result.hasErrors()) {
      return "addMovie";
    }

    movieRepository.save(movie);
    model.addAttribute("movies", movieRepository.findAll());
    return "MovieList";
  }

  // EditMovie
  @RequestMapping("/updateMovie")
  public String updateMovie(Movie movie) {
    return "updateMovie";
  }


  @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
  public String showUpdateForm(@PathVariable("id") String id, Model model) {
    Movie movie = movieRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
    model.addAttribute("movie",movie);
    return "updateMovie";
  }

  @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
  public String updateMovie(@Valid Movie movie, BindingResult result, Model model) {
    if (result.hasErrors()) {
      return "updateMovie";
    }

    movieRepository.save(movie);
    model.addAttribute("movies", movieRepository.findAll());
    return "MovieList";
  }

}

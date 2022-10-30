package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    ResponseEntity<String> addMovie(@RequestBody() Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @PostMapping("/add-director")
    ResponseEntity<String> addDirector(@RequestBody() Director director){
        movieService.addDirector(director);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

//    @PutMapping("/add-movie-director-pair")
//    ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie") String movieName,
//                                                @RequestParam("director")String directorName){
//        movieService.addMovieDirector(movieName, directorName);
//
//        return new ResponseEntity<>("Success", HttpStatus.OK);
//    }

    @PutMapping("/add-movie-director-pair")
    ResponseEntity<List<String>> addMovieDirectorPair(@RequestParam("movie") String movieName,
                                                @RequestParam("director")String directorName){
        movieService.addMovieDirector(movieName, directorName);

        List<String> list = movieService.getMoviesByDirectorName(directorName);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/get-movie-by-name/{name}")
    ResponseEntity<Movie> getMovieByName(@PathVariable("name") String movieName){
        Movie movie = movieService.getMovieByName(movieName);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @GetMapping("/get-director-by-name/{director}")
    ResponseEntity<Director> getDirectorByName(@PathVariable("director") String directorName){
        Director director = movieService.getDirectorByName(directorName);
        return new ResponseEntity<>(director, HttpStatus.OK);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("director") String directorName){
        List<String> movieList = movieService.getMoviesByDirectorName(directorName);
        return new ResponseEntity<>(movieList, HttpStatus.OK);
    }

    @GetMapping("/get-all-movies")
    ResponseEntity<List<String>> findAllMovies(){
        List<String> allMovies = movieService.getAllMovies();
        return new ResponseEntity<>(allMovies, HttpStatus.OK);
    }

    @DeleteMapping("/delete-director-by-name")
    ResponseEntity<String> deleteDirectorByName(@RequestParam("director") String director){
        movieService.deleteDirector(director);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @DeleteMapping("/delete-all-directors")
    ResponseEntity<String> deleteAllDirectors(){
        movieService.deleteAllDirectors();
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}

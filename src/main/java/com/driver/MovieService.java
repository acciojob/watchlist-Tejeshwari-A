package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    void addMovie(Movie movie){
        movieRepository.addMovie(movie);
    }

    Movie getMovieByName(String movieName){
        return movieRepository.getMovieByName(movieName);
    }

    List<String> getAllMovies(){
        return movieRepository.getAllMovies();
    }

    void addDirector(Director director){
        movieRepository.addDirector(director);
    }

    Director getDirectorByName(String directorName) {
        return movieRepository.getDirectorByName(directorName);
    }

    void addMovieDirector(String movieName, String directorName) {
        movieRepository.addMovieToDirector(movieName, directorName);
    }

    void deleteDirector(String director) {
        movieRepository.deleteDirector(director);
    }

    public void deleteAllDirectors() {
        movieRepository.deleteAllDirectors();
    }

    List<String> getMoviesByDirectorName(String directorName) {
        return movieRepository.getMoviesByDirector(directorName);
    }
}

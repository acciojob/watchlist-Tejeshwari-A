package com.driver;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class MovieRepository {
    HashMap<String, Movie> movieHashMap = new HashMap<>();
    HashMap<String, Director> directorHashMap = new HashMap<>();
    HashMap<String, List<String>> directorMoviesMap = new HashMap<>();

    void addMovie(Movie movie){
        movieHashMap.put(movie.name, movie);
    }

    void addDirector(Director director){
        directorHashMap.put(director.name, director);
    }

    void addMovieToDirector(String movieName, String directorName){
        List<String> movieList;

        if(directorMoviesMap.containsKey(directorName))
            movieList = directorMoviesMap.get(directorName);
        else {
            movieList = new ArrayList<>();
        }

        movieList.add(movieName);
        directorMoviesMap.put(directorName, movieList);
    }

    Movie getMovieByName(String movieName){
        return movieHashMap.get(movieName);
    }

    List<String> getAllMovies(){
        return new ArrayList<>(movieHashMap.keySet());
    }

    Director getDirectorByName(String directorName){
        return directorHashMap.get(directorName);
    }

    List<String> getMoviesByDirector(String directorName){
        return directorMoviesMap.get(directorName);
    }

    void deleteDirector(String director) {
        directorHashMap.remove(director);
        List<String> movieList = directorMoviesMap.remove(director);

        for(String movie : movieList) {
            movieHashMap.remove(movie);
        }
    }

    void deleteAllDirectors() {
        for(String director: directorHashMap.keySet()){
            if(directorMoviesMap.containsKey(director)) {
                List<String> movieList = directorMoviesMap.get(director);
                for (String movie : movieList) {
                    if(movieHashMap.containsKey(movie))
                        movieHashMap.remove(movie);
                }
            }
        }
        directorMoviesMap.clear();
        directorHashMap.clear();
    }

}

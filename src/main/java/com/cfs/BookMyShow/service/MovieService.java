package com.cfs.BookMyShow.service;

import com.cfs.BookMyShow.Model.Movie;
import com.cfs.BookMyShow.dto.MovieDto;
import com.cfs.BookMyShow.exception.ResourceNotFoundException;
import com.cfs.BookMyShow.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

   private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public MovieDto createMovie(MovieDto movieDto)
    {
        Movie movie=mapToEntity(movieDto);
        Movie saveMovie=movieRepository.save(movie);
        return mapToDto(saveMovie);
    }

    public MovieDto getMovieById(Long id)
    {
        Movie movie=movieRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Movie not found with id : "+id));
        return mapToDto(movie);
    }

    public List<MovieDto> getAllMovies()
    {
        List<Movie> movies=movieRepository.findAll();
        return movies.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public List<MovieDto> getMovieByLanguage(String language)
    {
        List<Movie> movies=movieRepository.findByLanguage(language);
        return movies.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
        //stream() → list ko process karne ke liye
        //map() → har element ko convert karne ke liye
        //collect() → result ko list me wapas lane ke liye
    }

    public List<MovieDto> getMovieByGenre(String genre)
    {
        List<Movie> movies=movieRepository.findByLanguage(genre);
        return movies.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }
    public List<MovieDto> searchMovies(String title)
    {
        List<Movie> movies=movieRepository.findByLanguage(title);
        return movies.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }


    public MovieDto updateMovie(Long id,MovieDto movieDto)
    {
        Movie movie=movieRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Movie not found with id : "+id));
        movie.setTitle(movieDto.getTitle());
        movie.setDescription(movieDto.getDescription());
        movie.setLanguage(movieDto.getLanguage());
        movie.setGenre(movieDto.getGenre());
        movie.setDurationMins(movieDto.getDurationMins());
        movie.setReleaseDate(movieDto.getReleaseDate());
        movie.setPosterUrl(movieDto.getPosterUrl());

        Movie updatedMovie = movieRepository.save(movie);
        return mapToDto(updatedMovie);
    }

    public void deleteMovie(Long id)
    {
        Movie movie=movieRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Movie not found with id : "+id));
        movieRepository.delete(movie);
    }


    private MovieDto mapToDto(Movie movie)
    {
        MovieDto movieDto=new MovieDto();
        movieDto.setId(movie.getId());
        movieDto.setTitle(movie.getTitle());
        movieDto.setDescription(movie.getDescription());
        movieDto.setLanguage(movie.getLanguage());
        movieDto.setGenre(movie.getGenre());
        movieDto.setDurationMins(movie.getDurationMins());
        movieDto.setReleaseDate(movie.getReleaseDate());
        movieDto.setPosterUrl(movie.getPosterUrl());
        return movieDto;
    }

    public Movie mapToEntity(MovieDto movieDto)
    {
        Movie movie=new Movie();
        movie.setTitle(movieDto.getTitle());
        movie.setDescription(movieDto.getDescription());
        movie.setLanguage(movieDto.getLanguage());
        movie.setGenre(movieDto.getGenre());
        movie.setDurationMins(movieDto.getDurationMins());
        movie.setReleaseDate(movieDto.getReleaseDate());
        movie.setPosterUrl(movieDto.getPosterUrl());
        return movie;
    }
}

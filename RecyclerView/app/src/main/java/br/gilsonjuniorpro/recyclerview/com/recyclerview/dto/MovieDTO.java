package br.gilsonjuniorpro.recyclerview.com.recyclerview.dto;

/**
 * Created by gilsonjuniorpro on 18/02/16.
 */
public class MovieDTO {

    private String title;
    private String genre;
    private String year;

    public MovieDTO() {
    }

    public MovieDTO(String title, String genre, String year) {
        this.title = title;
        this.genre = genre;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}

package br.gilsonjuniorpro.recyclerview.com.recyclerview.dto;

/**
 * Created by gilsonjuniorpro on 19/02/16.
 */
public class GenreDTO {

    private String codGenre;
    private String descr;

    public GenreDTO() {
    }

    public GenreDTO(String codGenre, String descr) {
        this.codGenre = codGenre;
        this.descr = descr;
    }

    public String getCodGenre() {
        return codGenre;
    }

    public void setCodGenre(String codGenre) {
        this.codGenre = codGenre;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }
}

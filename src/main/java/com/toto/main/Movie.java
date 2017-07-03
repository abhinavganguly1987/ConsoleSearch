package com.toto.main;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * Created by abhinavganguly on 03/07/2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {


    private String title;
    private String time;
    private String release_date;
    private String rating;
    private String genre;
    private String img;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String toMovieString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", runtime='" + time + '\'' +
                ", rating=" + rating +
                ", image url='" + img + '\'' +
                '}';
    }



    public String toAlbumString() {
        return "Album{" +
                "title='" + title + '\'' +
                ", release_date='" + release_date + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }


}

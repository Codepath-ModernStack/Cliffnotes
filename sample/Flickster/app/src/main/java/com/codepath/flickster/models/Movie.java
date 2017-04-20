package com.codepath.flickster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

public class Movie implements Serializable {
    private static final String BASE_IMAGE_PATH = "https://image.tmdb.org/t/p/";

    private String id;
    private String originalTitle;
    private String overview;
    private String backdropPath;
    private String posterPath;

    public String getId() {
        return id;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public String getBackdropImagePath() {
        return String.format("%sw1280/%s", BASE_IMAGE_PATH, backdropPath);
    }

    public String getPosterImagePath() {
        return String.format("%sw342/%s", BASE_IMAGE_PATH, posterPath);
    }

    public Movie(JSONObject jsonObject) throws JSONException {
        this.id = jsonObject.getString("id");
        this.posterPath = jsonObject.getString("poster_path");
        this.originalTitle = jsonObject.getString("original_title");
        this.overview = jsonObject.getString("overview");
        this.backdropPath = jsonObject.getString("backdrop_path");
    }

    public static ArrayList<Movie> fromJSONArray(JSONArray array) {
        ArrayList<Movie> results = new ArrayList<>();
        for (int x = 0; x < array.length(); x++) {
            try {
                Movie movie = new Movie(array.getJSONObject(x));
                results.add(movie);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return results;
    }
}

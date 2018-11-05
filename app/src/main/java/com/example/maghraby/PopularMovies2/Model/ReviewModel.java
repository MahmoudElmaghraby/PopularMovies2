package com.example.maghraby.PopularMovies2.Model;

import org.json.JSONException;
import org.json.JSONObject;

public class ReviewModel {

    private String id;
    private String author;
    private String content;

    public ReviewModel() {

    }

    public ReviewModel(JSONObject RjsonObject) throws JSONException {
        this.id = RjsonObject.getString("id");
        this.author = RjsonObject.getString("author");
        this.content = RjsonObject.getString("content");
    }

    public String getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }
}

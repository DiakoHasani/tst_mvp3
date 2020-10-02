package com.example.tst_mvp3.Models;

public class NewsModel {
    int id;
    String abstractNews;
    String dateInsert;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAbstractNews() {
        return abstractNews;
    }

    public void setAbstractNews(String abstractNews) {
        this.abstractNews = abstractNews;
    }

    public String getDateInsert() {
        return dateInsert;
    }

    public void setDateInsert(String dateInsert) {
        this.dateInsert = dateInsert;
    }
}

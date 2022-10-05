package com.example.firebasefirestorelibrary.presentation.model;

public class BookInfoModel {
    private String mTitle;
    private String mAuthor;
    private String mReleaseDate;
    private String[] mGenres;
    private String mDescription;

    public BookInfoModel(String title, String author, String releaseDate, String[] genres, String description) {
        mTitle = title;
        mAuthor = author;
        mReleaseDate = releaseDate;
        mGenres = genres;
        mDescription = description;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String author) {
        mAuthor = author;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        mReleaseDate = releaseDate;
    }

    public String[] getGenres() {
        return mGenres;
    }

    public void setGenres(String[] genres) {
        mGenres = genres;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }
}

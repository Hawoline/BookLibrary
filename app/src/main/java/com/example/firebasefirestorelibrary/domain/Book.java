package com.example.firebasefirestorelibrary.domain;

public class Book {
    private final String mTitle;
    private final String mAuthor;
    private String mReleaseDate;
    private String[] mGenres;
    private String mDescription;
    public Book(String title, String author) {
        this.mTitle = title;
        this.mAuthor = author;
    }

    public Book(String title, String author, String releaseDate, String[] genres, String description) {
        this(title, author);
        this.mReleaseDate = releaseDate;
        this.mGenres = genres;
        this.mDescription = description;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        if (mReleaseDate == null) {
            mReleaseDate = releaseDate;
        }
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

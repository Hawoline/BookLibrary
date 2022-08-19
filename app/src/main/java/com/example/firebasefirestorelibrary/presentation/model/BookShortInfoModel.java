package com.example.firebasefirestorelibrary.presentation.model;

public class BookShortInfoModel {
    private String mTitle;
    private String mAuthor;
    private String mReleaseDate;
    private int mLength;

    public BookShortInfoModel(String title, String author, String releaseDate, int length) {
        mTitle = title;
        mAuthor = author;
        mReleaseDate = releaseDate;
        mLength = length;
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

    public int getLength() {
        return mLength;
    }

    public void setLength(int length) {
        mLength = length;
    }
}

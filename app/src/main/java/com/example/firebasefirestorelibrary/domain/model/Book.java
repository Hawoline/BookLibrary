package com.example.firebasefirestorelibrary.domain.model;

public class Book {
    private final String mTitle;
    private final String mAuthor;
    private int mLength;
    private String mReleasedDate;
    private String mDescription;

    public Book(String title, String author) {
        this.mTitle = title;
        this.mAuthor = author;
    }

    public Book(String title, String author, int length, String releasedDate, String description) {
        this(title, author);
        this.mLength = length;
        this.mReleasedDate = releasedDate;
        this.mDescription = description;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public int getLength() {
        return mLength;
    }

    public void setLength(int length) {
        this.mLength = length;
    }

    public String getReleasedDate() {
        return mReleasedDate;
    }

    public void setReleasedDate(String releasedDate) {
        this.mReleasedDate = releasedDate;
    }
}

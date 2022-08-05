package com.example.firebasefirestorelibrary.domain.model;

import java.util.ArrayList;

public class User {
    private String mName;
    private ArrayList<Book> mBookmarkedBooks = new ArrayList<>();

    public User(String name, ArrayList<Book> bookmarkedBooks) {
        mName = name;
        mBookmarkedBooks.addAll(bookmarkedBooks);
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public ArrayList<Book> getBookmarkedBooks() {
        return mBookmarkedBooks;
    }

    public void addBookmark(Book book) {
        mBookmarkedBooks.add(book);
    }

    public void removeBookmark(Book book) {
        mBookmarkedBooks.remove(book);
    }

    public void removeBookmark(int bookPositionInBookmarks) {
        mBookmarkedBooks.remove(bookPositionInBookmarks);
    }
}

package com.example.firebasefirestorelibrary.presentation.mapper;

import com.example.firebasefirestorelibrary.domain.Book;
import com.example.firebasefirestorelibrary.presentation.model.BookInfoModel;

import java.util.ArrayList;

public class BookShortInfoDataMapper {

    public BookInfoModel transform(Book book) {
        return new BookInfoModel(
                book.getTitle(),
                book.getAuthor(),
                book.getReleaseDate(),
                book.getGenres(),
                book.getDescription()
        );
    }

    public ArrayList<BookInfoModel> transform(ArrayList<Book> books) {
        ArrayList<BookInfoModel> bookShortInfoModels = new ArrayList<>();
        for (Book book : books) {
            bookShortInfoModels.add(transform(book));
        }

        return bookShortInfoModels;
    }
}

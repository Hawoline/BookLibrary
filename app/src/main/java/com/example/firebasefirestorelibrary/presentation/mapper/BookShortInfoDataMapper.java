package com.example.firebasefirestorelibrary.presentation.mapper;

import com.example.firebasefirestorelibrary.domain.Book;
import com.example.firebasefirestorelibrary.presentation.model.BookShortInfoModel;

import java.util.ArrayList;

public class BookShortInfoDataMapper {

    public BookShortInfoModel transform(Book book) {
        return new BookShortInfoModel(
                book.getTitle(),
                book.getAuthor(),
                book.getReleasedDate(),
                book.getLength()
        );
    }

    public ArrayList<BookShortInfoModel> transform(ArrayList<Book> books) {
        ArrayList<BookShortInfoModel> bookShortInfoModels = new ArrayList<>();
        for (Book book : books) {
            bookShortInfoModels.add(transform(book));
        }

        return bookShortInfoModels;
    }
}

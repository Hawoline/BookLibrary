package com.example.firebasefirestorelibrary.presentation.presenter;

import com.example.firebasefirestorelibrary.presentation.model.BookInfoModel;

public interface MainPresenter extends BasePresenter {
    BookInfoModel[] searchBookShortInfo(String searchQuery);
}

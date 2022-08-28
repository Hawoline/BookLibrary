package com.example.firebasefirestorelibrary.presentation.presenter;

import android.content.Intent;
import com.example.firebasefirestorelibrary.presentation.model.BookShortInfoModel;

public interface MainPresenter extends BasePresenter {
    BookShortInfoModel[] searchBookShortInfo(Intent intent, String searchQuery);
}

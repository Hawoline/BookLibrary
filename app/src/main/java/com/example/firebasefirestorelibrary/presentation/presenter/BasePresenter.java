package com.example.firebasefirestorelibrary.presentation.presenter;

import com.example.firebasefirestorelibrary.presentation.view.MainView;

public interface BasePresenter {
    void attachMainView(MainView mainView);
    void detachMainView();
}

package com.example.firebasefirestorelibrary.presentation.presenter;

import android.app.SearchManager;
import android.content.Intent;
import android.widget.Toast;
import com.example.firebasefirestorelibrary.data.net.RestApi;
import com.example.firebasefirestorelibrary.data.net.RestApiImpl;
import com.example.firebasefirestorelibrary.presentation.model.BookShortInfoModel;
import com.example.firebasefirestorelibrary.presentation.view.BookListAdapter;
import com.example.firebasefirestorelibrary.presentation.view.MainView;
import com.example.firebasefirestorelibrary.util.JsonParser;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MainPresenterImpl implements MainPresenter {
    private MainView mMainView;

    @Override
    public void attachMainView(MainView mainView) {
        mMainView = mainView;
    }

    @Override
    public void detachMainView() {
        mMainView = null;
    }

    @Override
    public BookShortInfoModel[] searchBookShortInfo(Intent intent, String searchQuery) {
        BookShortInfoModel[] bookShortInfoModels = new BookShortInfoModel[] {};

        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() {
                RestApi restApi = new RestApiImpl(mMainView.getContext());
                return restApi.searchBooks(searchQuery);
            }
        };

        FutureTask<String> future = new FutureTask<>(callable);
        new Thread(future).start();
        try {
            bookShortInfoModels = JsonParser.parseBookShortInfoModels(future.get());
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return bookShortInfoModels;
    }
}

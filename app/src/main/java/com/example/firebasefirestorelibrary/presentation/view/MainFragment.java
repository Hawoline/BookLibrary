package com.example.firebasefirestorelibrary.presentation.view;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.example.firebasefirestorelibrary.R;
import com.example.firebasefirestorelibrary.data.net.RestApi;
import com.example.firebasefirestorelibrary.data.net.RestApiImpl;
import com.example.firebasefirestorelibrary.domain.Book;
import com.example.firebasefirestorelibrary.presentation.model.BookShortInfoModel;
import com.example.firebasefirestorelibrary.presentation.presenter.MainPresenter;
import com.example.firebasefirestorelibrary.presentation.presenter.MainPresenterImpl;
import com.example.firebasefirestorelibrary.util.JsonParser;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MainFragment extends Fragment implements MainView {
    private RecyclerView mBookRecyclerView;
    private ImageButton mShowAdvancedOptionsButton;
    private LinearLayout mBookmarksOptionsLayout;
    private RadioGroup mReadOptionsRadioGroup;

    private MainPresenter mMainPresenter;

    public MainFragment() {
        super(R.layout.view_main);
    }

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainPresenter = new MainPresenterImpl();
        mMainPresenter.attachMainView(this);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);

        Intent intent = requireActivity().getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            mBookRecyclerView.setAdapter(new BookListAdapter(mMainPresenter.searchBookShortInfo(intent, intent.getStringExtra(SearchManager.QUERY))));
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        mMainPresenter.detachMainView();
    }

    public void initViews(View baseView) {
        mBookRecyclerView = baseView.findViewById(R.id.main_recyclerview_book_list);
        mShowAdvancedOptionsButton = baseView.findViewById(R.id.booklistoptions_button_show_advanced_options);
        mBookmarksOptionsLayout = baseView.findViewById(R.id.booklistoptions_layout_bookmarks_options);
        mReadOptionsRadioGroup = baseView.findViewById(R.id.booklistoptions_group_read_option);
        mShowAdvancedOptionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBookmarksOptionsLayout.getVisibility() == View.GONE) {
                    mBookmarksOptionsLayout.setVisibility(View.VISIBLE);
                } else {
                    mBookmarksOptionsLayout.setVisibility(View.GONE);
                }
            }
        });
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public Context getContext() {
        return requireActivity().getApplicationContext();
    }
}

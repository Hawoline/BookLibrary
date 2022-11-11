package com.example.firebasefirestorelibrary.presentation.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.example.firebasefirestorelibrary.R;
import com.example.firebasefirestorelibrary.presentation.mapper.BookInfoBundleMapper;
import com.example.firebasefirestorelibrary.presentation.model.BookInfoModel;
import com.example.firebasefirestorelibrary.presentation.presenter.MainPresenter;
import com.example.firebasefirestorelibrary.presentation.presenter.MainPresenterImpl;
import org.jetbrains.annotations.NotNull;

public class MainFragment extends Fragment implements MainView, BookListAdapter.OnBookClickListener {
    private RecyclerView mBookRecyclerView;
    private ImageButton mShowAdvancedOptionsButton;
    private LinearLayout mBookmarksOptionsLayout;
    private RadioGroup mReadOptionsRadioGroup;
    private EditText mSearchBookEditText;
    private Button mSearchBookButton;

    public static final String BUNDLE_KEY_BOOK_INFO = "BUNDLE_KEY_BOOK_INFO";

    private MainPresenter mMainPresenter;

    private BookListAdapter mBookListAdapter;

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
    public void onViewCreated(@NonNull @NotNull View view,
                              @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findViews(view);
    }

    @Override
    public void onResume() {
        super.onResume();
        mMainPresenter.attachMainView(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        mMainPresenter.detachMainView();
    }

    public void findViews(View baseView) {
        mBookRecyclerView = baseView.findViewById(R.id.main_recyclerview_book_list);
        mShowAdvancedOptionsButton = baseView.findViewById(R.id.booklistoptions_button_show_advanced_options);
        mBookmarksOptionsLayout = baseView.findViewById(R.id.booklistoptions_layout_bookmarks_options);
        mReadOptionsRadioGroup = baseView.findViewById(R.id.booklistoptions_group_read_option);
        mShowAdvancedOptionsButton.setOnClickListener(view -> {
            if (mBookmarksOptionsLayout.getVisibility() == View.GONE) {
                mBookmarksOptionsLayout.setVisibility(View.VISIBLE);
            } else {
                mBookmarksOptionsLayout.setVisibility(View.GONE);
            }
        });
        mSearchBookEditText = baseView.findViewById(R.id.search_edittext_search_text);
        mSearchBookEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN &&
                        keyCode == KeyEvent.KEYCODE_ENTER
                ) {
                    showSearchedBooks(mSearchBookEditText.getText().toString().trim());
                    mSearchBookEditText.clearFocus();
                    mSearchBookEditText.setCursorVisible(false);

                    return true;
                }
                return false;
            }
        });
        mSearchBookButton = baseView.findViewById(R.id.search_button_search);
        mSearchBookButton.setOnClickListener(view -> {
            showSearchedBooks(mSearchBookEditText.getText().toString().trim());
        });
    }

    private void showSearchedBooks(String query) {
        BookInfoModel[] bookInfoModels = mMainPresenter.searchBookShortInfo(query);
        if (mBookListAdapter == null) {
            mBookListAdapter = new BookListAdapter(bookInfoModels);
        } else {
            mBookListAdapter.setBooks(bookInfoModels);
        }
        mBookListAdapter.setOnBookClickListener(this);
        mBookRecyclerView.setAdapter(mBookListAdapter);
    }
    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public Context getContext() {
        return requireActivity().getApplicationContext();
    }

    @Override
    public void showFailedResultToast() {
        Toast.makeText(getContext(), R.string.search_result_is_empty, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBookItemClicked(BookInfoModel bookInfoModel) {
        Bundle bookInfoBundle = new Bundle();
        bookInfoBundle.putBundle(BUNDLE_KEY_BOOK_INFO, BookInfoBundleMapper.toBundle(bookInfoModel));
        getParentFragmentManager()
                .beginTransaction()
                .replace(R.id.container_main, BookInfoFragment.class, bookInfoBundle)
                .addToBackStack(null)
                .commit();
    }
}

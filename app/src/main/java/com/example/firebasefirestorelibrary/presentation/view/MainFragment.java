package com.example.firebasefirestorelibrary.presentation.view;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.example.firebasefirestorelibrary.R;
import com.example.firebasefirestorelibrary.domain.Book;
import org.jetbrains.annotations.NotNull;

public class MainFragment extends Fragment implements MainView {
    private RecyclerView mBookRecyclerView;
    private ImageButton mShowAdvancedOptionsButton;
    private LinearLayout mBookmarksOptionsLayout;
    private RadioGroup mReadOptionsRadioGroup;

    public MainFragment() {
        super(R.layout.view_main);
    }

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    public void initViews(View baseView) {
        mBookRecyclerView = baseView.findViewById(R.id.main_recyclerview_book_list);
        Book[] books = new Book[40];
        for (int i = 0; i < books.length; i++) {
            books[i] = new Book("title: " + i, "fknvkjdfv", 104, "13.08.2001", "");
        }
        mBookRecyclerView.setAdapter(new BookListAdapter(books));

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
}

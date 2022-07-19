package com.example.firebasefirestorelibrary.presentation.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.example.firebasefirestorelibrary.R;
import com.example.firebasefirestorelibrary.presentation.model.Book;
import org.jetbrains.annotations.NotNull;

public class MainFragment extends Fragment implements MainView {
    private RecyclerView mBookRecyclerView;
    private ImageButton mShowAdvancedOptionsButton;
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
            books[i] = new Book("kfjnjvdf", "fknvkjdfv", 104, "13.08.2001");
        }
        mBookRecyclerView.setAdapter(new BookListAdapter(books));

        mShowAdvancedOptionsButton = baseView.findViewById(R.id.booksort_button_show_advanced_options);
        mReadOptionsRadioGroup = baseView.findViewById(R.id.booksort_group_read_option);
        mShowAdvancedOptionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mReadOptionsRadioGroup.getVisibility() == View.GONE) {
                    mReadOptionsRadioGroup.setVisibility(View.VISIBLE);
                } else {
                    mReadOptionsRadioGroup.setVisibility(View.GONE);
                }
            }
        });
    }
}

package com.example.firebasefirestorelibrary.presentation.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.firebasefirestorelibrary.R;
import com.example.firebasefirestorelibrary.presentation.mapper.BookInfoBundleMapper;
import com.example.firebasefirestorelibrary.presentation.model.BookInfoModel;
import org.jetbrains.annotations.NotNull;

public class BookInfoFragment extends Fragment implements BookInfoView {
    private TextView mTitleTextView;
    private TextView mAuthorNameTextView;
    private TextView mGenresTextView;
    private TextView mPublishedDateTextView;
    private TextView mDescriptionTextView;

    public BookInfoFragment() {
        super(R.layout.view_book_info);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        showBookInfo(BookInfoBundleMapper.toBookInfo(requireArguments().getBundle(MainFragment.BUNDLE_KEY_BOOK_INFO)));
    }

    @Override
    public void initViews(View baseView) {
        mTitleTextView = baseView.findViewById(R.id.bookinfo_textview_title);
        mAuthorNameTextView = baseView.findViewById(R.id.bookinfo_textview_author_name);
        mGenresTextView = baseView.findViewById(R.id.bookinfo_textview_genres);
        mPublishedDateTextView = baseView.findViewById(R.id.bookinfo_textview_published_date);
        mDescriptionTextView = baseView.findViewById(R.id.bookinfo_textview_description);
    }

    @Override
    public Context getContext() {
        return requireActivity().getApplicationContext();
    }

    @Override
    public void showBookInfo(BookInfoModel bookInfoModel) {
        mTitleTextView.setText(bookInfoModel.getTitle());
        mAuthorNameTextView.setText(bookInfoModel.getAuthor());
        StringBuilder appendedGenres = new StringBuilder();
        for (String genre: bookInfoModel.getGenres()) {
            appendedGenres.append(genre);
            appendedGenres.append(" ");
        }
        mGenresTextView.setText(appendedGenres.toString());
        mPublishedDateTextView.setText(bookInfoModel.getReleaseDate());
        mDescriptionTextView.setText(bookInfoModel.getDescription());
    }
}

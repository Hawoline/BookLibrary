package com.example.firebasefirestorelibrary.presentation.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.firebasefirestorelibrary.R;
import com.example.firebasefirestorelibrary.presentation.model.BookInfoModel;
import org.jetbrains.annotations.NotNull;

public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.BookViewHolder> {
    private BookInfoModel[] mBooks;

    public BookListAdapter(BookInfoModel[] books) {
        mBooks = books;
    }

    @NonNull
    @NotNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item_view, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull BookViewHolder holder, int position) {
        BookInfoModel currentBookShortInfoModel = mBooks[position];
        holder.mTitleTextView.setText(currentBookShortInfoModel.getTitle());
        holder.mAuthorTextView.setText(currentBookShortInfoModel.getAuthor());
        holder.mReleasedDateTextView.setText(currentBookShortInfoModel.getReleaseDate());
    }

    @Override
    public int getItemCount() {
        return mBooks.length;
    }

    public static class BookViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitleTextView;
        private TextView mAuthorTextView;
        private TextView mReleasedDateTextView;
        private ImageView mCoverImageView;

        public BookViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            mTitleTextView = itemView.findViewById(R.id.main_textview_book_title);
            mAuthorTextView = itemView.findViewById(R.id.main_textview_book_author);
            mReleasedDateTextView = itemView.findViewById(R.id.main_textview_released_date);
            mCoverImageView = itemView.findViewById(R.id.main_imageview_book_cover);
        }
    }
}

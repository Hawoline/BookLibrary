package com.example.firebasefirestorelibrary.presentation.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.firebasefirestorelibrary.R;
import com.example.firebasefirestorelibrary.presentation.model.Book;
import org.jetbrains.annotations.NotNull;

public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.BookViewHolder> {
    private Book[] mBooks;

    public BookListAdapter(Book[] books) {
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
        holder.mTitleTextView.setText(mBooks[position].getTitle());
        holder.mAuthorTextView.setText(mBooks[position].getAuthor());
        holder.mLengthTextView.setText(String.valueOf(mBooks[position].getLength()));
        holder.mReleasedDateTextView.setText(mBooks[position].getReleasedDate());
    }

    @Override
    public int getItemCount() {
        return mBooks.length;
    }

    public static class BookViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitleTextView;
        private TextView mAuthorTextView;
        private TextView mLengthTextView;
        private TextView mReleasedDateTextView;
        private ImageView mCoverImageView;

        public BookViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            mTitleTextView = itemView.findViewById(R.id.main_textview_book_title);
            mAuthorTextView = itemView.findViewById(R.id.main_textview_book_author);
            mLengthTextView = itemView.findViewById(R.id.main_textview_length);
            mReleasedDateTextView = itemView.findViewById(R.id.main_textview_released_date);
            mCoverImageView = itemView.findViewById(R.id.main_imageview_book_cover);
        }
    }
}

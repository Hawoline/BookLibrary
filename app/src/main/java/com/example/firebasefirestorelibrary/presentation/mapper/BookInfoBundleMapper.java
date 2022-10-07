package com.example.firebasefirestorelibrary.presentation.mapper;

import android.os.Bundle;
import com.example.firebasefirestorelibrary.presentation.model.BookInfoModel;

public class BookInfoBundleMapper {
    private static final String BUNDLE_KEY_TITLE = "TITLE_KEY";
    private static final String BUNDLE_KEY_AUTHOR = "AUTHOR_KEY";
    private static final String BUNDLE_KEY_PUBLISHED_DATE = "PUBLISHED_DATE_KEY";
    private static final String BUNDLE_KEY_GENRES = "GENRES_KEY";
    private static final String BUNDLE_KEY_DESCRIPTION = "DESCRIPTION_KEY";

    public static Bundle toBundle(BookInfoModel bookInfoModel) {
        Bundle result = new Bundle();
        result.putString(BUNDLE_KEY_TITLE, bookInfoModel.getTitle());
        result.putString(BUNDLE_KEY_AUTHOR, bookInfoModel.getAuthor());
        result.putString(BUNDLE_KEY_PUBLISHED_DATE, bookInfoModel.getReleaseDate());
        result.putString(BUNDLE_KEY_GENRES, bookInfoModel.getGenres());
        result.putString(BUNDLE_KEY_DESCRIPTION, bookInfoModel.getDescription());

        return result;
    }

    public static BookInfoModel toBookInfo(Bundle bookInfoBundle) {
        return new BookInfoModel(
                bookInfoBundle.getString(BUNDLE_KEY_TITLE),
                bookInfoBundle.getString(BUNDLE_KEY_AUTHOR),
                bookInfoBundle.getString(BUNDLE_KEY_PUBLISHED_DATE),
                bookInfoBundle.getString(BUNDLE_KEY_GENRES),
                bookInfoBundle.getString(BUNDLE_KEY_DESCRIPTION)
        );
    }
}

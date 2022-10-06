package com.example.firebasefirestorelibrary.util;

import com.example.firebasefirestorelibrary.presentation.model.BookInfoModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonParser {
    public static BookInfoModel[] parseBookShortInfoModels(String query) {
        JSONObject searchJsonObject;
        BookInfoModel[] bookShortInfoModels;
        try {
            searchJsonObject = new JSONObject(query);
            int resultCount = searchJsonObject.getInt("resultCount");
            bookShortInfoModels = new BookInfoModel[resultCount];
            JSONArray results = searchJsonObject.getJSONArray("results");
            for (int result = 0; result < results.length(); result++) {
                JSONObject resultJsonObject = results.getJSONObject(result);
                bookShortInfoModels[result] = parseBookShortInfoModel(resultJsonObject);
            }

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        
        return bookShortInfoModels;
    }

    private static BookInfoModel parseBookShortInfoModel(JSONObject bookInfoJsonObject) {
        BookInfoModel bookShortInfoModel;
        try {
            JSONArray bookGenresJsonArray = bookInfoJsonObject.getJSONArray("genres");
            String[] genres = new String[bookGenresJsonArray.length()];
            for (int bookGenre = 0; bookGenre < bookGenresJsonArray.length(); bookGenre++) {
                genres[bookGenre] = bookGenresJsonArray.getString(bookGenre);
            }
            bookShortInfoModel = new BookInfoModel(
                    bookInfoJsonObject.getString("trackName"),
                    bookInfoJsonObject.getString("artistName"),
                    SimpleDateFormatter.format(bookInfoJsonObject.getString("releaseDate")),
                    genres,
                    bookInfoJsonObject.getString("description")
            );
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        return bookShortInfoModel;
    }
}

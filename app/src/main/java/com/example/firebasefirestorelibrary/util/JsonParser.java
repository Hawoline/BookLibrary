package com.example.firebasefirestorelibrary.util;

import com.example.firebasefirestorelibrary.presentation.model.BookShortInfoModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonParser {
    public static BookShortInfoModel[] parseBookShortInfoModels(String query) {
        JSONObject searchJsonObject;
        BookShortInfoModel[] bookShortInfoModels;
        try {
            searchJsonObject = new JSONObject(query);
            int resultCount = searchJsonObject.getInt("resultCount");
            bookShortInfoModels = new BookShortInfoModel[resultCount];
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

    private static BookShortInfoModel parseBookShortInfoModel(JSONObject bookInfoJsonObject) {
        BookShortInfoModel bookShortInfoModel;
        try {
            bookShortInfoModel = new BookShortInfoModel(
                    bookInfoJsonObject.getString("trackName"),
                    bookInfoJsonObject.getString("artistName"),
                    bookInfoJsonObject.getString("releaseDate"),
                    0
            );
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        return bookShortInfoModel;
    }
}

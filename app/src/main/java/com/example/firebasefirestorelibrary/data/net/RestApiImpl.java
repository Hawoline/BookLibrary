package com.example.firebasefirestorelibrary.data.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.net.MalformedURLException;

public class RestApiImpl implements RestApi {
    private Context mContext;

    public RestApiImpl(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("The constructor parameters cannot be null!");
        }
        mContext = context.getApplicationContext();
    }

    @Override
    public String searchBooks(String searchBookRequest) {
        if (!isThereInternetConnection()) {
            return "Internet Connection failed";
        }
        if (searchBookRequest.equals("")) {
            return "";
        }

        String response = "";
        try {
            response = getSearchResultsFromApi(searchBookRequest);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return response;
    }

    private String getSearchResultsFromApi(String searchBookRequest) throws MalformedURLException {
        return ApiConnection.createGET(API_BASE_URL +
                API_TERM + searchBookRequest.trim() +
                API_COUNTRY +
                API_MEDIA
        ).requestSyncCall();
    }

    private boolean isThereInternetConnection() {
        boolean isConnected;

        ConnectivityManager connectivityManager =
                (ConnectivityManager) this.mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        isConnected = (networkInfo != null && networkInfo.isConnectedOrConnecting());

        return isConnected;
    }
}

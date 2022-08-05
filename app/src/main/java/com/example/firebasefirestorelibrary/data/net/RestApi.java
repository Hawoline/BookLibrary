package com.example.firebasefirestorelibrary.data.net;

public interface RestApi {
  String API_BASE_URL = "https://itunes.apple.com/search?";
  String API_TERM = "term=";
  String API_COUNTRY = "&country=RU";
  String API_MEDIA = "&media=eboook";

  String searchBooks(String searchBookRequest);
}
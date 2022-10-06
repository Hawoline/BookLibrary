package com.example.firebasefirestorelibrary.util;

public class SimpleDateFormatter {

    // String format is yyyy-MM-ddTHH:mm:ssZ
    public static String format(String isoDate) {
        String rawDate = isoDate.substring(0, 9);
        String[] resultDate = rawDate.split("-");
        if (resultDate.length < 3) {
            return "Format error";
        }

        return resultDate[2] + "/" + resultDate[1] + "/" + resultDate[0];
    }
}

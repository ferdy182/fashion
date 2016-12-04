package com.fernandofgallego.stylight;

import okhttp3.logging.HttpLoggingInterceptor;

public class Constants {
    public static final String API_BASE_URL = " https://api.stylight.com/rest/";

    public static final String HEADER_LOCALE_NAME = "X-Locale";
    public static final String HEADER_LOCALE_VALUE = "de_DE";
    public static final String HEADER_API_KEY_NAME = "X-apiKey";
    public static final String HEADER_API_KEY_VALUE = "C6490912AB3211E680F576304DEC7EB7";

    public static final int ID_PRODUCTS_CLOTHING = 10203;
    public static final int ID_PRODUCTS_LAMPS = 28107;

    public static final String ID_POSTS_FASHION = "fashion";
    public static final String ID_POSTS_LIFESTYLE = "lifestyle";

    public static final HttpLoggingInterceptor.Level HTTP_LOG_LEVEL = HttpLoggingInterceptor.Level.BASIC;
}

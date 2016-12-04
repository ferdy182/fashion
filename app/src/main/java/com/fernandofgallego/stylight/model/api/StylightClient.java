package com.fernandofgallego.stylight.model.api;

import com.fernandofgallego.stylight.BuildConfig;
import com.fernandofgallego.stylight.Constants;
import com.google.gson.GsonBuilder;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public enum StylightClient {
    INSTANCE;

    private Api api;

    private StylightClient() {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        httpClient.addInterceptor(new HeaderInterceptor());

        // log requests body only in debug mode
        if(BuildConfig.DEBUG) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(Constants.HTTP_LOG_LEVEL);
            httpClient.addInterceptor(httpLoggingInterceptor);
        }

        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl(Constants.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setPrettyPrinting().create()))
                .client(httpClient.build());


        Retrofit retrofit = retrofitBuilder.build();

        api = retrofit.create(Api.class);
    }

    public Api getApi() {
        return api;
    }

    private static class HeaderInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request original = chain.request();

            // Request customization: add request headers
            Request.Builder requestBuilder = original.newBuilder()
                    .header(Constants.HEADER_LOCALE_NAME, Constants.HEADER_LOCALE_VALUE)
                    .header(Constants.HEADER_API_KEY_NAME, Constants.HEADER_API_KEY_VALUE);

            Request request = requestBuilder.build();
            return chain.proceed(request);
        }
    }
}

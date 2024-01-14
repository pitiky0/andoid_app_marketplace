package com.projects.marketplace.api;

import com.projects.marketplace.model.Article;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public class StoreApiClient {

    private static final String BASE_URL = "https://fakestoreapi.com/";

    private static Retrofit retrofit;

    public static FakeStoreApi getApi() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(FakeStoreApi.class);
    }

    public interface FakeStoreApi {

        @GET("products")
        Call<List<Article>> getProducts();

        @GET("products/{id}")
        Call<Article> getProductById(@Path("id") int productId);

        @GET("products/categories")
        Call<List<String>> getCategories();

        @GET("products/category/{category}")
        Call<List<Article>> getProductsByCategory(@Path("category") String category);

        @GET("products")
        Call<List<Article>> getLimitedProducts(@Query("limit") int limit);
    }
}

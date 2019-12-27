package com.practise.googlenewspractiseusingmvvm;

import com.practise.googlenewspractiseusingmvvm.Model.NewsResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    String BASE_URL="https://newsapi.org/v2/";
    @GET("top-headlines?country=de")

//    @GET("top-headlines?country=de&category=business&apiKey=8a72ef51ea9c463bbce9eb97955b8283")
    Call<NewsResponse> getNewsResponse(@Query("category") String category,
                                       @Query("apiKey") String api);


}

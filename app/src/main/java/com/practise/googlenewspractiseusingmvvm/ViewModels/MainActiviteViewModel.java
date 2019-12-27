package com.practise.googlenewspractiseusingmvvm.ViewModels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.practise.googlenewspractiseusingmvvm.Api;

import com.practise.googlenewspractiseusingmvvm.Model.Articles;
import com.practise.googlenewspractiseusingmvvm.Model.NewsResponse;
import com.practise.googlenewspractiseusingmvvm.Model.source;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActiviteViewModel extends ViewModel {

    MutableLiveData<NewsResponse> newsresponse;


    public LiveData<NewsResponse> getNewsresponse() {
        if(newsresponse==null){
            newsresponse=new MutableLiveData<>();

            loadNews("business");
        }


        return newsresponse;
    }

    public void loadNews(String category){
        Retrofit retrofit=new Retrofit.Builder()
                   .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Api.BASE_URL)
                .build();

        Api api=retrofit.create(Api.class);
        Call<NewsResponse> call=api.getNewsResponse(category, "8a72ef51ea9c463bbce9eb97955b8283");
        Log.e(" Login url", call.request().url().toString());

        call.enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {

                newsresponse.setValue(response.body());

            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                Log.e("dsdasdasdad", ""+t.getMessage());

            }
        });






    }
}

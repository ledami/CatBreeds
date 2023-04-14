package com.ledami.catbreeds.data;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ledami.catbreeds.model.CatBreed;
import com.ledami.catbreeds.model.ImageCatBreed;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CatBreedRepository {
    private TaskCatBreed taskCatBreed;

    public CatBreedRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.thecatapi.com/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        taskCatBreed = retrofit.create(TaskCatBreed.class);
    }

    public LiveData<List<CatBreed>> getTaskCatBreed() {
        MutableLiveData<List<CatBreed>> data = new MutableLiveData<>();
        taskCatBreed.getCatBreeds().enqueue(new Callback<List<CatBreed>>() {
            @Override
            public void onResponse(Call<List<CatBreed>> call, Response<List<CatBreed>> response) {
                if (response.isSuccessful()) {
                    data.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<CatBreed>> call, Throwable t) {
                Log.e("FAILURE","Error enviando peticion:" + t.getMessage());
                Log.e("FAILURE",call.request().toString());


            }
        });

        return data;
    }
    public LiveData<ImageCatBreed> getImage() {
        MutableLiveData<ImageCatBreed> data = new MutableLiveData<>();
        taskCatBreed.getImagesCatBreeds().enqueue(new Callback<ImageCatBreed>() {
            @Override
            public void onResponse(Call<ImageCatBreed> call, Response<ImageCatBreed> response) {
                if (response.isSuccessful()) {
                    data.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<ImageCatBreed> call, Throwable t) {
                Log.e("FAILURE","Error enviando peticion:" + t.getMessage());
                Log.e("FAILURE",call.request().toString());
            }
        });

        return data;
    }
}

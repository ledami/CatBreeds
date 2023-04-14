package com.ledami.catbreeds.data;

import com.ledami.catbreeds.model.CatBreed;
import com.ledami.catbreeds.model.ImageCatBreed;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TaskCatBreed {
    @GET("breeds")
    Call<List<CatBreed>> getCatBreeds();

    @GET("images")
    Call<ImageCatBreed> getImagesCatBreeds();
}

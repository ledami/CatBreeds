package com.ledami.catbreeds.viewmodel;

import androidx.lifecycle.LiveData;

import com.ledami.catbreeds.data.CatBreedRepository;
import com.ledami.catbreeds.model.CatBreed;

import java.util.List;

public class CatBreedViewModel {
    LiveData<List<CatBreed>> data;

    public CatBreedViewModel() {
        CatBreedRepository catBreedRepository= new CatBreedRepository();
        data = catBreedRepository.getTaskCatBreed();
    }

    public LiveData<List<CatBreed>> getCatBreeds(){
        return data;
    }
}

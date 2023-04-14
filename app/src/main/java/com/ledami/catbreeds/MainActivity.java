package com.ledami.catbreeds;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ledami.catbreeds.adapter.CatBreedAdapter;
import com.ledami.catbreeds.databinding.ActivityMainBinding;
import com.ledami.catbreeds.model.CatBreed;
import com.ledami.catbreeds.viewmodel.CatBreedViewModel;

import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private CatBreedViewModel catBreedViewModel;
    private CatBreedAdapter catBreedAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        RecyclerView recyclerView = (binding.rvCatBreeds);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        catBreedAdapter = new CatBreedAdapter();
        recyclerView.setAdapter(catBreedAdapter);

       catBreedViewModel = new CatBreedViewModel();
        //  catBreedViewModel = ViewModelProviders.of(this).get(CatBreedViewModel.class);
        catBreedViewModel.getCatBreeds().observe(this, new Observer<List<CatBreed>>() {
            @Override
            public void onChanged(List<CatBreed> catBreeds) {
                catBreedAdapter.setCatBreeds(catBreeds);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
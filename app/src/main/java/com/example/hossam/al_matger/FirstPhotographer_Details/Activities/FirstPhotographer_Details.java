package com.example.hossam.al_matger.FirstPhotographer_Details.Activities;

import android.arch.lifecycle.Observer;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.view.WindowManager;

import com.example.hossam.al_matger.FirstNearest_Photographer.Adapter.FirstNearest_Photographer_Adapter;
import com.example.hossam.al_matger.FirstNearest_Photographer.ViewModel.Nearest_PhotographerViewModel;
import com.example.hossam.al_matger.FirstPhotographer_Details.Adapter.RecyclePhotographerImagesAdapter;
import com.example.hossam.al_matger.R;

import java.util.ArrayList;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class FirstPhotographer_Details extends AppCompatActivity {

    private RecyclerView recyclerView;
    RecyclePhotographerImagesAdapter recyclePhotographerImagesAdapter;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.first_photographer_details);
        recyclerView =findViewById(R.id.recylerview);
        recyclerView.setLayoutManager(new GridLayoutManager(FirstPhotographer_Details.this,2));
        recyclePhotographerImagesAdapter = new RecyclePhotographerImagesAdapter(FirstPhotographer_Details.this);
        recyclerView.setAdapter(recyclePhotographerImagesAdapter);

    }
}

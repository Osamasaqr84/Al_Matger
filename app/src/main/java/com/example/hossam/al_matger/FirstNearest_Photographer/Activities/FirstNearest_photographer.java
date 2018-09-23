package com.example.hossam.al_matger.FirstNearest_Photographer.Activities;

import android.arch.lifecycle.Observer;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.view.WindowManager;

import com.example.hossam.al_matger.FirstMyChats.Adapter.FirstMyChatAdapter;
import com.example.hossam.al_matger.FirstMyChats.ViewModel.MyChats_ItemViewModel;
import com.example.hossam.al_matger.FirstNearest_Photographer.Adapter.FirstNearest_Photographer_Adapter;
import com.example.hossam.al_matger.FirstNearest_Photographer.ViewModel.Nearest_PhotographerViewModel;
import com.example.hossam.al_matger.R;

import java.util.ArrayList;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class FirstNearest_photographer extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Nearest_PhotographerViewModel nearest_photographerViewModel;
    private FirstNearest_Photographer_Adapter firstMyChatAdapter;
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
        setContentView(R.layout.first_nearest_photographer_list);

        recyclerView =findViewById(R.id.recylerview);
        nearest_photographerViewModel = new Nearest_PhotographerViewModel();
        nearest_photographerViewModel.getData().observe(this, new Observer<ArrayList<Nearest_PhotographerViewModel>>() {
            @Override
            public void onChanged(@Nullable ArrayList<Nearest_PhotographerViewModel> arrayList) {
                firstMyChatAdapter = new FirstNearest_Photographer_Adapter(FirstNearest_photographer.this,arrayList);
                recyclerView.setLayoutManager(new GridLayoutManager(FirstNearest_photographer.this,1));
                recyclerView.setAdapter(firstMyChatAdapter);
            }
        });

    }
}

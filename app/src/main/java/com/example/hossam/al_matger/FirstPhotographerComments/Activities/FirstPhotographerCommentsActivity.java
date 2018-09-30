package com.example.hossam.al_matger.FirstPhotographerComments.Activities;

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
import com.example.hossam.al_matger.FirstPhotographerComments.Adapter.FirstPhotographerCommentsAdapter;
import com.example.hossam.al_matger.FirstPhotographerComments.ViewModel.MyPhotographer_comments_ViewModel;
import com.example.hossam.al_matger.R;

import java.util.ArrayList;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class FirstPhotographerCommentsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyPhotographer_comments_ViewModel photographer_comments_viewModel;
    private FirstPhotographerCommentsAdapter photographerCommentsAdapter;
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
        setContentView(R.layout.first_photographercomments_list);
        recyclerView =findViewById(R.id.recylerview);

        photographer_comments_viewModel = new MyPhotographer_comments_ViewModel();
        photographer_comments_viewModel.getData().observe(this, new Observer<ArrayList<MyPhotographer_comments_ViewModel>>() {
            @Override
            public void onChanged(@Nullable ArrayList<MyPhotographer_comments_ViewModel> arrayList) {
                photographerCommentsAdapter = new FirstPhotographerCommentsAdapter(FirstPhotographerCommentsActivity.this,arrayList);
                recyclerView.setLayoutManager(new GridLayoutManager(FirstPhotographerCommentsActivity.this,1));
                recyclerView.setAdapter(photographerCommentsAdapter);
            }
        });

    }
}

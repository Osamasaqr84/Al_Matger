package com.example.hossam.al_matger.FirstMyChats.Activities;

import android.arch.lifecycle.Observer;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.view.WindowManager;

import com.example.hossam.al_matger.FirstMyChats.Adapter.FirstMyChatAdapter;
import com.example.hossam.al_matger.FirstMyChats.ViewModel.MyChats_ItemViewModel;
import com.example.hossam.al_matger.FirstMyOrders.Adapter.FirstMyOrderAdapter;
import com.example.hossam.al_matger.FirstMyOrders.Fragments.MainFragment;
import com.example.hossam.al_matger.FirstMyOrders.ViewModel.MyOrders_ItemViewModel;
import com.example.hossam.al_matger.R;

import java.util.ArrayList;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class FirstMyChatActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyChats_ItemViewModel myChats_itemViewModel;
    private FirstMyChatAdapter firstMyChatAdapter;
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
        setContentView(R.layout.first_mychat_list);


        recyclerView =findViewById(R.id.recylerview);

        myChats_itemViewModel = new MyChats_ItemViewModel();
        myChats_itemViewModel.getData().observe(this, new Observer<ArrayList<MyChats_ItemViewModel>>() {
            @Override
            public void onChanged(@Nullable ArrayList<MyChats_ItemViewModel> arrayList) {
                firstMyChatAdapter = new FirstMyChatAdapter(FirstMyChatActivity.this,arrayList);
                recyclerView.setLayoutManager(new GridLayoutManager(FirstMyChatActivity.this,1));
                recyclerView.setAdapter(firstMyChatAdapter);
            }
        });

    }
}

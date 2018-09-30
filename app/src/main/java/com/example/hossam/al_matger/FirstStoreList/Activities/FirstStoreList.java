package com.example.hossam.al_matger.FirstStoreList.Activities;

import android.arch.lifecycle.Observer;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.hossam.al_matger.FirstStoreList.Adapter.StoreListAdapter;
import com.example.hossam.al_matger.R;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class FirstStoreList extends AppCompatActivity {

    private RecyclerView recyclerView;
    private StoreListAdapter firstStoreListAdapter;
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_list);
        recyclerView =findViewById(R.id.recylerview);
        firstStoreListAdapter = new StoreListAdapter(FirstStoreList.this);
        recyclerView.setNestedScrollingEnabled(true);
        recyclerView.setAdapter(firstStoreListAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(FirstStoreList.this,1));

    }
}

package com.example.hossam.al_matger.FirstDeliveryOffers.Activities;

import android.arch.lifecycle.Observer;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.view.WindowManager;

import com.example.hossam.al_matger.FirstDeliveryOffers.Adapter.DeliveryOffersAdapter;
import com.example.hossam.al_matger.FirstDeliveryOffers.ViewModel.DeliveryOffersViewModel;
import com.example.hossam.al_matger.FirstdealerAccount.Activities.FirstdealerAccount;
import com.example.hossam.al_matger.FirstdealerAccount.Adapter.DepartmentAdapter;
import com.example.hossam.al_matger.FirstdealerAccount.ViewModel.DepartmentViewModel;
import com.example.hossam.al_matger.R;

import java.util.ArrayList;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class FirstDeliveryOffers extends AppCompatActivity {

    RecyclerView recyclerView;
    DeliveryOffersViewModel deliveryOffersViewModel;
    DeliveryOffersAdapter departmentAdapter;
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
        setContentView(R.layout.firstdeliveryoffers);
        recyclerView = findViewById(R.id.account_recycler);
        deliveryOffersViewModel = new DeliveryOffersViewModel();

        deliveryOffersViewModel.getData().observe(this, new Observer<ArrayList<DeliveryOffersViewModel>>() {
            @Override
            public void onChanged(@Nullable ArrayList<DeliveryOffersViewModel> arrayList) {

                departmentAdapter = new DeliveryOffersAdapter(FirstDeliveryOffers.this,arrayList);
                recyclerView.setLayoutManager(new GridLayoutManager(FirstDeliveryOffers.this,1));
                recyclerView.setAdapter(departmentAdapter);
            }
        });
    }
}

package com.example.hossam.al_matger.FirstdealerAccount.Activities;

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

import com.example.hossam.al_matger.FirstdealerAccount.Adapter.DepartmentAdapter;
import com.example.hossam.al_matger.FirstdealerAccount.ViewModel.DepartmentViewModel;
import com.example.hossam.al_matger.R;

import java.util.ArrayList;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class FirstdealerAccount extends AppCompatActivity {
    RecyclerView recyclerView;
    DepartmentViewModel departmentViewModel;
    DepartmentAdapter departmentAdapter;
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

        setContentView(R.layout.firstdealeraccount);

        recyclerView = findViewById(R.id.account_recycler);
        departmentViewModel = new DepartmentViewModel();


        departmentViewModel.getData().observe(this, new Observer<ArrayList<DepartmentViewModel>>() {
            @Override
            public void onChanged(@Nullable ArrayList<DepartmentViewModel> arrayList) {

                departmentAdapter = new DepartmentAdapter(FirstdealerAccount.this,arrayList);
                recyclerView.setLayoutManager(new GridLayoutManager(FirstdealerAccount.this,3));
                recyclerView.setAdapter(departmentAdapter);
            }
        });
    }
}

package com.example.hossam.al_matger.FirstMyAccount.Activities;

import android.arch.lifecycle.Observer;
import android.content.Context;
import android.support.annotation.Nullable;
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

public class FirstMyAccount extends AppCompatActivity {
    
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
        setContentView(R.layout.firstmyccount);

    }
}

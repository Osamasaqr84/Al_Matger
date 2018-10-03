package com.example.hossam.al_matger.Orders.FirstConfirmOrder.Activities;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.hossam.al_matger.R;
import com.example.hossam.al_matger.ThirdSubCategry.Fragments.MainFragment;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class FirstConfirmOrderActivity extends AppCompatActivity {
    Fragment fragment;
    FragmentManager fr;
    FragmentTransaction ft;

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
        setContentView(R.layout.firstconfirmorder);



    }
}

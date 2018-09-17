package com.example.hossam.al_matger.FirstResturantList.Activities;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.hossam.al_matger.FirstResturantList.Fragments.MainFragment;
import com.example.hossam.al_matger.R;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class FirstResturantListActivity extends AppCompatActivity {
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
        setContentView(R.layout.firstresturantlist);
        /////////initialze the main fragment
        fragment = new MainFragment();
        fr = getSupportFragmentManager();
        ft = fr.beginTransaction();
        ft.replace(R.id.main_frame, fragment);
        ft.commit();

    }
}

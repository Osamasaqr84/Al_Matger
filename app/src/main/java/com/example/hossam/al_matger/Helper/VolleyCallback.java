package com.example.hossam.al_matger.Helper;

import com.android.volley.VolleyError;

import org.json.JSONException;

/**
 * Created by AG on 1/29/2017.
 */

public interface VolleyCallback {
    public void onSuccess(String result) throws JSONException;
     public void onError(VolleyError error);
}
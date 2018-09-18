package com.example.hossam.al_matger.FirstNewOrder;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.example.hossam.al_matger.Helper.AsyncTaskCompleteListener;
import com.example.hossam.al_matger.Helper.BeanRoute;
import com.example.hossam.al_matger.Helper.BeanStep;
import com.example.hossam.al_matger.Helper.Json_Controller;
import com.example.hossam.al_matger.Helper.PolyLineUtils;
import com.example.hossam.al_matger.Helper.VolleyCallback;
import com.example.hossam.al_matger.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Response;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class FirstNewOrder extends AppCompatActivity implements OnMapReadyCallback , GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener,
        AsyncTaskCompleteListener
        , NavigationView.OnNavigationItemSelectedListener,
        View.OnClickListener
   {
       private GoogleApiClient mGoogleApiClient;

       GoogleMap m_map;
       boolean mapReady = false;
       private BeanRoute routeClient;
       private ArrayList<LatLng> pointsClient;
       private Polyline polyLineClient;
       private PolylineOptions lineOptionsClient;

       double currentLatitude =29.990060, currentLongitude = 31.264525 ;
       double nextLatitude =30.107982, nextLongitude = 31.234092 ;

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
        setContentView(R.layout.firstneworder);
        if (servicesOK()) {
            buildGoogleApi();
            mGoogleApiClient.connect();
            //client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).addApi(Places.GEO_DATA_API).build();
        }
        MapFragment mMap = (MapFragment) getFragmentManager().findFragmentById(R.id.mapsss);
        //mMap.getMapAsync(this);
        mMap.getMapAsync(this);

    }
       protected synchronized void buildGoogleApi() {
           mGoogleApiClient = new GoogleApiClient.Builder(this)
                   .addConnectionCallbacks(this)
                   .addOnConnectionFailedListener(this)
                   .addApi(LocationServices.API)
                   .build();
       }
       public boolean servicesOK() {
           int isAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
           if (isAvailable == ConnectionResult.SUCCESS) {
               return true;
           } else if (GooglePlayServicesUtil.isUserRecoverableError(isAvailable)) {
             //  Dialog dialog = GooglePlayServicesUtil.getErrorDialog(isAvailable, this, ERROR_DIALOG_REQUEST);
             //  dialog.show();
           } else {
             //  Toast.makeText(this, getString(R.string.checkgps), Toast.LENGTH_LONG).show();
           }
           return false;
       }
       @Override
       public void onMapReady(GoogleMap googleMap) {
           mapReady = true;
           m_map = googleMap;
           drawPathToClient();
       }

       public void drawPathToClient() {
           new Json_Controller().GetDataFromServer(new VolleyCallback() {
               @Override
               public void onSuccess(String result) {
               //    removeSimpleProgressDialog();
                   if (!TextUtils.isEmpty(result)) {
                       routeClient = new BeanRoute();
                       parseRoute(result, routeClient);
                       final ArrayList<BeanStep> step = routeClient.getListStep();
                       pointsClient = new ArrayList<LatLng>();
                       lineOptionsClient = new PolylineOptions();

                       for (int i = 0; i < step.size(); i++) {
                           List<LatLng> path = step.get(i).getListPoints();
                           pointsClient.addAll(path);
                       }
                       if (polyLineClient != null)
                           polyLineClient.remove();
                       lineOptionsClient.addAll(pointsClient);
                       lineOptionsClient.width(5);
                       lineOptionsClient.color(Color.RED);
                       if (lineOptionsClient != null && m_map != null) {
                           if(pointsClient.size()>=1) {
                               m_map.clear();
                               m_map.addMarker(new MarkerOptions().position(pointsClient.get(pointsClient.size() - 1)));
                               m_map.addMarker(new MarkerOptions().position(pointsClient.get(0)));
                               polyLineClient = m_map.addPolyline(lineOptionsClient);
                               LatLngBounds.Builder builder = new LatLngBounds.Builder();
                               builder.include(new LatLng(currentLatitude, currentLongitude));
                               builder.include(new LatLng(nextLatitude,nextLatitude));
                               LatLngBounds bounds = builder.build();
                               CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, 70);
                               if (m_map != null) {
                                   m_map.animateCamera(cu);
                               }
                           }
                       }
                   }
               }
               @Override
               public void onError(VolleyError error) {
               }
           }, FirstNewOrder.this, "https://maps.googleapis.com/maps/api/directions/json?origin="
                   + currentLatitude + "," + currentLongitude
                   + "&destination=" + nextLatitude + ","
                   + nextLongitude + "&sensor=false&key=" + getString(R.string.google_maps_key), false);
       }

       public BeanRoute parseRoute(String response, BeanRoute routeBean) {

           try {
               BeanStep stepBean;
               JSONObject jObject = new JSONObject(response);
               JSONArray jArray = jObject.getJSONArray("routes");
               for (int i = 0; i < jArray.length(); i++) {
                   JSONObject innerjObject = jArray.getJSONObject(i);
                   if (innerjObject != null) {
                       JSONArray innerJarry = innerjObject.getJSONArray("legs");
                       for (int j = 0; j < innerJarry.length(); j++) {

                           JSONObject jObjectLegs = innerJarry.getJSONObject(j);
                           routeBean.setDistanceText(jObjectLegs.getJSONObject(
                                   "distance").getString("text"));
                           routeBean.setDistanceValue(jObjectLegs.getJSONObject(
                                   "distance").getInt("value"));

                           routeBean.setDurationText(jObjectLegs.getJSONObject(
                                   "duration").getString("text"));
                           routeBean.setDurationValue(jObjectLegs.getJSONObject(
                                   "duration").getInt("value"));

                           routeBean.setStartAddress(jObjectLegs
                                   .getString("start_address"));
                           routeBean.setEndAddress(jObjectLegs
                                   .getString("end_address"));

                           routeBean.setStartLat(jObjectLegs.getJSONObject(
                                   "start_location").getDouble("lat"));
                           routeBean.setStartLon(jObjectLegs.getJSONObject(
                                   "start_location").getDouble("lng"));
                           routeBean.setEndLat(jObjectLegs.getJSONObject(
                                   "end_location").getDouble("lat"));
                           routeBean.setEndLon(jObjectLegs.getJSONObject(
                                   "end_location").getDouble("lng"));

                           JSONArray jstepArray = jObjectLegs
                                   .getJSONArray("steps");
                           if (jstepArray != null) {
                               for (int k = 0; k < jstepArray.length(); k++) {
                                   stepBean = new BeanStep();
                                   JSONObject jStepObject = jstepArray
                                           .getJSONObject(k);
                                   if (jStepObject != null) {

                                       stepBean.setHtml_instructions(jStepObject
                                               .getString("html_instructions"));
                                       stepBean.setStrPoint(jStepObject
                                               .getJSONObject("polyline")
                                               .getString("points"));
                                       stepBean.setStartLat(jStepObject
                                               .getJSONObject("start_location")
                                               .getDouble("lat"));
                                       stepBean.setStartLon(jStepObject
                                               .getJSONObject("start_location")
                                               .getDouble("lng"));
                                       stepBean.setEndLat(jStepObject
                                               .getJSONObject("end_location")
                                               .getDouble("lat"));
                                       stepBean.setEndLong(jStepObject
                                               .getJSONObject("end_location")
                                               .getDouble("lng"));

                                       stepBean.setListPoints(new PolyLineUtils()
                                               .decodePoly(stepBean.getStrPoint()));
                                       routeBean.getListStep().add(stepBean);
                                   }
                               }
                           }
                       }
                   }
               }
           } catch (JSONException e) {
               e.printStackTrace();
           }
           return routeBean;
       }

       @Override
       public void onLocationChanged(Location location) {

       }

       @Override
       public void onStatusChanged(String provider, int status, Bundle extras) {

       }

       @Override
       public void onProviderEnabled(String provider) {

       }

       @Override
       public void onProviderDisabled(String provider) {

       }

       @Override
       public boolean onNavigationItemSelected(@NonNull MenuItem item) {
           return false;
       }

       @Override
       public void onClick(View v) {

       }

       @Override
       public void onConnected(@Nullable Bundle bundle) {

       }

       @Override
       public void onConnectionSuspended(int i) {

       }

       @Override
       public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

       }

       @Override
       public void onTaskCompleted(String response, int serviceCode) {

       }
   }




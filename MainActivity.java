package com.subham99.hikerswatch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
LocationManager locationManager;
LocationListener locationListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        locationManager = (LocationManager) this.getSystemService (Context.LOCATION_SERVICE);
        locationListener = new LocationListener () {
            @Override
            public void onLocationChanged(@NonNull Location location) {
                updateLocation (location);
            }
        };
        if (ContextCompat.checkSelfPermission (this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions (this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);

        }
        else
        {
            locationManager.requestLocationUpdates (LocationManager.GPS_PROVIDER,0,0,locationListener);
            Location lastKnownLocation = locationManager.getLastKnownLocation (LocationManager.GPS_PROVIDER);
            if (lastKnownLocation != null)
            {
                updateLocation (lastKnownLocation);
            }
        }

    }
    public  void  updateLocation(Location location)
    {
          Log.i ("Location",location.toString ());
          TextView latitude = findViewById (R.id.latitude);
          TextView longitude = findViewById (R.id.longitude);
          TextView accuracy = findViewById (R.id.accuracy);
          TextView locality = findViewById (R.id.locality);

          

          latitude.setText ("Latitude :   " + Double.toString (location.getLatitude ()));
          longitude.setText ("Longitude :   " + Double.toString (location.getLongitude ()));
          accuracy.setText ("Accuracy :   " + Double.toString (location.getAccuracy ()));

          String current_address = ":(";
        Geocoder geocoder = new Geocoder (this, Locale.getDefault ());
        try {
            List<Address> list = geocoder.getFromLocation (location.getLatitude (),location.getLongitude (),1);
            if(list != null && list.size () >0)
            {
                current_address = " ";

                if (list.get(0).getLocality () != null)
                {
                    locality.setText (list.get (0).getAddressLine (0));
                }


            }

        }catch(Exception e)
        {
            e.printStackTrace ();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult (requestCode, permissions, grantResults);
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
        {
            startListening();
        }
    }

    private void startListening() {
        if (ContextCompat.checkSelfPermission (this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
        {
            locationManager.requestLocationUpdates (LocationManager.GPS_PROVIDER,0,0,locationListener);
        }
    }
}
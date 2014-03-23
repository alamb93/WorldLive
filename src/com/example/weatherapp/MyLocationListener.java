package com.example.weatherapp;

import android.app.Activity;
import android.location.Location;
import android.location.LocationListener;
import android.widget.Toast;
import android.os.Bundle;
import android.widget.Toast;

public class MyLocationListener extends Activity implements LocationListener { 
   
  public void onLocationChanged(Location loc) { 
    
  } 

  public void onProviderDisabled(String provider) { 

  } 
 
  public void onProviderEnabled(String provider) { 
    Toast.makeText( getApplicationContext(), "Gps Enabled", Toast.LENGTH_SHORT).show(); 
  } 

  public void onStatusChanged(String provider, int status, Bundle extras) { 

  }
  
}

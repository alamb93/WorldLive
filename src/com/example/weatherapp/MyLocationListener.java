package com.example.weatherapp;

import android.app.Activity;
import android.location.Location;
import android.location.LocationListener;
import android.widget.Toast;
import android.os.Bundle;
import android.widget.Toast;

  public class MyLocationListener extends Activity implements LocationListener 
 { 
//
// @Override 
  public void onLocationChanged(Location loc) 
 { 
////just passing the current latitude and logtude values to an external class 
////for later use.     
//CurrentLocation.Latitude =Double.toString(loc.getLatitude());
//CurrentLocation.Longitude = Double.toString(loc.getLongitude());
//
//String Text = "My current location is: " + 
//
//"Latitud = " + loc.getLatitude() + 
//
//"Longitud = " + loc.getLongitude(); 
//
//Toast.makeText(getApplicationContext(), Text, Toast.LENGTH_SHORT).show();
 } 
//    
//@Override 
//
  public void onProviderDisabled(String provider) 
  { 
//Toast.makeText(getApplicationContext(), "Gps Disabled", Toast.LENGTH_SHORT ).show(); 
  } 
//
 
public void onProviderEnabled(String provider) 
{ 
Toast.makeText( getApplicationContext(), "Gps Enabled", Toast.LENGTH_SHORT).show(); 
} 
//
  public void onStatusChanged(String provider, int status, Bundle extras) 
 { 
 } 
}
package com.example.weatherapp;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import android.view.KeyEvent;
import android.view.View;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;
import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.wifi.p2p.WifiP2pManager.ActionListener;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.TextView.OnEditorActionListener;

public class MainActivity extends Activity implements GooglePlayServicesClient.ConnectionCallbacks,
GooglePlayServicesClient.OnConnectionFailedListener, OnEditorActionListener {
	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
//	private final static int
//    CONNECTION_FAILURE_RESOLUTION_REQUEST = 9000;
//	Location mLocation;
//	
//	public static class ErrorDialogFragment extends DialogFragment {
//        // Global field to contain the error dialog
//        private Dialog mDialog;
//        // Default constructor. Sets the dialog field to null
//        public ErrorDialogFragment() {
//            super();
//            mDialog = null;
//        }
//        // Set the dialog to display
//        public void setDialog(Dialog dialog) {
//            mDialog = dialog;
//        }
//        // Return a Dialog to the DialogFragment.
//        @Override
//        public Dialog onCreateDialog(Bundle savedInstanceState) {
//            return mDialog;
//        }
//    }
//    /*
//     * Handle results returned to the FragmentActivity
//     * by Google Play services
//     */
//    @Override
//    protected void onActivityResult(
//            int requestCode, int resultCode, Intent data) {
//        // Decide what to do based on the original request code
//        switch (requestCode) {
//            
//            case CONNECTION_FAILURE_RESOLUTION_REQUEST :
//            /*
//             * If the result code is Activity.RESULT_OK, try
//             * to connect again
//             */
//                switch (resultCode) {
//                    case Activity.RESULT_OK :
//                    /*
//                     * Try the request again
//                     */
//                   
//                    break;
//                }
//            
//        }
//     }
//    
//    private boolean servicesConnected() {
//        // Check that Google Play services is available
//        int resultCode =
//                GooglePlayServicesUtil.
//                        isGooglePlayServicesAvailable(this);
//        // If Google Play services is available
//        if (ConnectionResult.SUCCESS == resultCode) {
//            // In debug mode, log the status
//            Log.d("Location Updates",
//                    "Google Play services is available.");
//            // Continue
//            return true;
//        // Google Play services was not available for some reason
//        } else {
//            // Get the error code
//            // Get the error dialog from Google Play services
//            Dialog errorDialog = GooglePlayServicesUtil.getErrorDialog(
//                    resultCode,
//                    this,
//                    CONNECTION_FAILURE_RESOLUTION_REQUEST);
//
//            // If Google Play services can provide an error dialog
//            if (errorDialog != null) {
//                // Create a new DialogFragment for the error dialog
//                ErrorDialogFragment errorFragment =
//                        new ErrorDialogFragment();
//                // Set the dialog in the DialogFragment
//                errorFragment.setDialog(errorDialog);
//                // Show the error dialog in the DialogFragment
//                //fixed it by changing to getFragmentManager .... acc
//               errorFragment.show(getFragmentManager(),"Location Updates");
//            }
//        }
//		return false;
//    }
//	 LocationClient mLocationClient = new LocationClient(this, this, this);
	
	 protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		EditText editText = (EditText) findViewById(R.id.edit_message);
		editText.setOnEditorActionListener(new OnEditorActionListener() {
		    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
		        boolean handled = false;
		        if (actionId == EditorInfo.IME_ACTION_SEND) {
		            //sendMessage();
		            handled = true;
		        }
		        return handled;
		    }
		});
		// Get a handle to the Map Fragment
		GoogleMap map = ((MapFragment) getFragmentManager()
				.findFragmentById(R.id.map)).getMap();
//mLocation = mLocationClient.getLastLocation();
		LatLng sydney = new LatLng(-33.867, 151.206);
		LatLng UNC = new LatLng(35.9083, -79.0500);
		LatLng USM = new LatLng(39.9139, 116.3917);
		LatLng JPN = new LatLng(35.6984, 139.7731);
		map.setMyLocationEnabled(true);		
		
		final Marker mark = map.addMarker(new MarkerOptions()
		.title("Sydney")
		.snippet("All Sun! #BEACH!")
		.position(sydney));
		
		final Marker hack = map.addMarker(new MarkerOptions()
		.title("UNC-PearlHacks")
		.snippet("Raining Enthusiasm")
		.position(UNC));
		
		final Marker Min = map.addMarker(new MarkerOptions()
		.title("Beijing")
		.snippet("Suspicious Activity at the mall!! LI YUAN!!!!")
		.position(USM));
		
		final Marker Aki = map.addMarker(new MarkerOptions()
		.title("Akihabara, Japan")
		.snippet("それは曇っている")
		.position(JPN));
		
		long ticks = 1000;
		long fiveMin = 200000;
		CountDownTimer MapTime = new CountDownTimer(fiveMin, ticks) {

			@Override
			public void onFinish() {
				mark.remove();
				
			}

			@Override
			public void onTick(long millisUntilFinished) {
				// TODO Auto-generated method stub
				
			}
		};
		MapTime.start();
		
		LocationManager mlocManager = (LocationManager)getSystemService
                (Context.LOCATION_SERVICE); 
      LocationListener mlocListener = new MyLocationListener(); 

      mlocManager.requestLocationUpdates( LocationManager.GPS_PROVIDER, 
                0, 0, mlocListener); 
	}

//	 public void sendMessage(View view) {
//		 Intent intent = new Intent(this, DisplayMessageActivity.class);
//		 EditText editText = (EditText) findViewById(R.id.edit_message);
//		 String message = editText.getText().toString();
//		 intent.putExtra(EXTRA_MESSAGE, message);		}
@Override
public void onConnectionFailed(ConnectionResult result) {
	// TODO Auto-generated method stub
	
}

@Override
public void onConnected(Bundle connectionHint) {
	// TODO Auto-generated method stub
	
}

@Override
public void onDisconnected() {
	// TODO Auto-generated method stub
	
}

public void onFailure(int reason) {
	// TODO Auto-generated method stub
	
}

public void onSuccess() {
	// TODO Auto-generated method stub
	
}

@Override
public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
	// TODO Auto-generated method stub
	return false;
}
	
//	 protected void onStart() {
//	        super.onStart();
//	        // Connect the client.
//	        mLocationClient.connect();
//	    }
//	   
//	    @Override
//	    protected void onStop() {
//	        // Disconnecting the client invalidates it.
//	        mLocationClient.disconnect();
//	        super.onStop();
//	    }
//
//		@Override
//		public void onConnectionFailed(ConnectionResult connectionResult) {
//			 if (connectionResult.hasResolution()) {
//		            try {
//		                // Start an Activity that tries to resolve the error
//		                connectionResult.startResolutionForResult(
//		                        this,
//		                        CONNECTION_FAILURE_RESOLUTION_REQUEST);
//		                /*
//		                 * Thrown if Google Play services canceled the original
//		                 * PendingIntent
//		                 */
//		            } catch (IntentSender.SendIntentException e) {
//		                // Log the error
//		                e.printStackTrace();
//		            }
//		        } else {
//		            /*
//		             * If no resolution is available, display a dialog to the
//		             * user with the error.
//		             */
//		            showDialog(connectionResult.getErrorCode());
//		        }			
//		}
//
//		@Override
//		public void onConnected(Bundle connectionHint) {
//			Toast.makeText(this, "Connected", Toast.LENGTH_SHORT).show();			
//		}
//
//		@Override
//		public void onDisconnected() {
//			Toast.makeText(this, "Disconnected. Please re-connect.",
//	                Toast.LENGTH_SHORT).show();			
//		}
}

package annina.halloandroid;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.widget.TextView;


import java.util.List;

public class LocationActivitiy extends Activity {


    private static final int REQUEST_PERMISSION_ACCESS_FINE_LOCATION
            = 123;

    private TextView tv;
    private LocationManager locationManager;
    private LocationListener locationListener;
    private String p;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        tv = findViewById(R.id.textLocationView);
        tv.setText("");
        // Berechtigungen prüfen
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]
                            {Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_PERMISSION_ACCESS_FINE_LOCATION);
        } else {
            doIt();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[],
                                           int[] grantResults) {
        if ((requestCode == REQUEST_PERMISSION_ACCESS_FINE_LOCATION) &&
                (grantResults.length > 0 && grantResults[0] ==
                        PackageManager.PERMISSION_GRANTED)) {
            doIt();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            locationManager.requestLocationUpdates(p, 3000, 0, locationListener);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            locationManager.removeUpdates(locationListener);
        }
    }

    private void doIt() {
        // LocationManager-Instanz ermitteln
        locationManager = getSystemService(LocationManager.class);
        if (locationManager == null) {
            finish();
        }

        // Provider mit grober Auflösung
        // und niedrigem Energieverbrauch
        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_COARSE);
        criteria.setPowerRequirement(Criteria.POWER_LOW);
        p = locationManager.getBestProvider(criteria, true);
        tv.append("\nVerwende " + p + "\n");
        // LocationListener-Objekt erzeugen
        locationListener = new LocationListener() {
            @Override
            public void onStatusChanged(String provider, int status,
                                        Bundle extras) {
//                tv.append("onStatusChanged()\n");
            }

            @Override
            public void onProviderEnabled(String provider) {
//                tv.append("onProviderEnabled()\n");
            }

            @Override
            public void onProviderDisabled(String provider) {
//                tv.append("onProviderDisabled()\n");
            }

            @Override
            public void onLocationChanged(Location location) {
//                tv.append("\nonLocationChanged()\n");
                if (location != null) {
                    String s = "Breite: " + location.getLatitude()
                            + "\nLänge: " + location.getLongitude();
                    tv.append(s + "\n");
                }
            }
        };
//        // Umwandlung von String- in double-Werte
//        Location locNuernberg = new Location(
//                LocationManager.GPS_PROVIDER);
//        double latitude = Location.convert("49:27");
//        locNuernberg.setLatitude(latitude);
//        double longitude = Location.convert("11:5");
//        locNuernberg.setLongitude(longitude);
//        tv.append("\nlatitude: " + locNuernberg.getLatitude() + "\n");
//        tv.append("longitude: " + locNuernberg.getLongitude() + "\n");
    }
}

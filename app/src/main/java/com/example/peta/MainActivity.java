 package com.example.peta;

 import android.Manifest;
 import android.content.pm.PackageManager;
 import android.location.Location;
 import android.os.Bundle;
 import android.view.View;
 import android.widget.ImageButton;
 import android.widget.Toast;

 import androidx.annotation.NonNull;
 import androidx.core.app.ActivityCompat;
 import androidx.fragment.app.FragmentActivity;

 import com.google.android.gms.location.FusedLocationProviderClient;
 import com.google.android.gms.location.LocationServices;
 import com.google.android.gms.maps.CameraUpdateFactory;
 import com.google.android.gms.maps.GoogleMap;
 import com.google.android.gms.maps.OnMapReadyCallback;
 import com.google.android.gms.maps.SupportMapFragment;
 import com.google.android.gms.maps.model.BitmapDescriptorFactory;
 import com.google.android.gms.maps.model.LatLng;
 import com.google.android.gms.maps.model.MarkerOptions;
 import com.google.android.gms.tasks.OnSuccessListener;
 import com.google.android.gms.tasks.Task;

 public class MainActivity extends FragmentActivity implements OnMapReadyCallback {

     Location currentLocation;
     private GoogleMap mMap;
     private ImageButton button1;
     private ImageButton button2;
     private Integer loc;

     FusedLocationProviderClient fusedLocationProviderClient;
     private static final int REQUEST_CODE = 101;
     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
         button1= findViewById(R.id.button1);
         button2= findViewById(R.id.button2);
         fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
         button1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 loc =0;
                 fetchLastLocation();
             }
         });
         button2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 loc = 1;
                 fetchLastLocation();
             }
         });

     }

     private void fetchLastLocation() {
         if(ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
             ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_CODE);
             return;
         }
         Task<Location> task = fusedLocationProviderClient.getLastLocation();
         task.addOnSuccessListener(new OnSuccessListener<Location>() {
             @Override
             public void onSuccess(Location location) {
                 if(location != null){
                     currentLocation = location;
                     Toast.makeText(getApplicationContext(),currentLocation.getLatitude()
                             +""+currentLocation.getLongitude(),Toast.LENGTH_SHORT).show();
                     SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.google_map);
                     supportMapFragment.getMapAsync(MainActivity.this);
                 }
             }
         });
     }

     @Override
     public void onMapReady(GoogleMap googleMap) {

         mMap = googleMap;
         mMap.getUiSettings().setZoomControlsEnabled(true);



         if (loc== 0){
             LatLng latLng= new LatLng(currentLocation.getLatitude(),currentLocation.getLongitude());
             MarkerOptions markerOptions = new MarkerOptions().position(latLng).title("LOKASI SAYA").snippet("Jl. RA. Kartini, Rt : 03, Rw: 01, Kel. Mangundikaran, Kec. Nganjuk");
             markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)); //icon marker untuk lokasi saat ini
             googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
             googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,15)); //supaya saat apk dibuka langsung menuju ke tempat yg ditandai
             googleMap.addMarker(markerOptions);

         }
         else {
             LatLng SMA1 = new LatLng(-7.600800, 111.889445);
             googleMap.addMarker(new MarkerOptions().position(SMA1).title("SMA Negeri 1 Nganjuk").snippet("Jl. Kap. Kasihin Hs No.4, Cangkringan, Bogo, Kec. Nganjuk, Kabupaten Nganjuk, Jawa Timur 64415" +
                     "\n"));
             googleMap.animateCamera(CameraUpdateFactory.newLatLng(SMA1));
             googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(SMA1,15));

             LatLng SMA2 = new LatLng(-7.619670, 111.898137);
             googleMap.addMarker(new MarkerOptions().position(SMA2).title("SMA Negeri 2 Nganjuk").snippet("Nganjuk, Winong, Ploso, Kec. Nganjuk, Kabupaten Nganjuk, Jawa Timur 64417" +
                     "\n"));
             googleMap.animateCamera(CameraUpdateFactory.newLatLng(SMA2));
             googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(SMA2,15));

             LatLng SMA3 = new LatLng(-7.581558, 111.903923);
             googleMap.addMarker(new MarkerOptions().position(SMA3).title("SMA Negeri 3 Nganjuk").snippet("Jalan Bengawan Solo, Kelurahan No.109, Mangunan, Begadung, Kec. Nganjuk, Kabupaten Nganjuk, Jawa Timur 64413"));
             googleMap.animateCamera(CameraUpdateFactory.newLatLng(SMA3));
             googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(SMA3,15));

             LatLng SMA4 = new LatLng(-7.598574, 111.902824);
             googleMap.addMarker(new MarkerOptions().position(SMA4).title("SMA Muhammadiyah 1 Nganjuk").snippet("Jl. Panglima Sudirman III No.1, RT.04/RW.03, Mangundikaran, Mangun Dikaran, Kec. Nganjuk, Kabupaten Nganjuk, Jawa Timur 64412"));
             googleMap.animateCamera(CameraUpdateFactory.newLatLng(SMA4));
             googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(SMA4,15));

             LatLng SMA5 = new LatLng(-7.602636, 111.899483);
             googleMap.addMarker(new MarkerOptions().position(SMA5).title("SMA Diponegoro Nganjuk").snippet("Jl. Kyai H. Agus Salim No.6, Kauman, Kec. Nganjuk, Kabupaten Nganjuk, Jawa Timur 64411"));
             googleMap.animateCamera(CameraUpdateFactory.newLatLng(SMA5));
             googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(SMA5,15));

             LatLng SMA6 = new LatLng(-7.610938, 111.915438);
             googleMap.addMarker(new MarkerOptions().position(SMA6).title("SMA Khatolik St. Agustinus Nganjuk").snippet("Jl. Wilis No.20, Jarakan, Kramat, Kec. Nganjuk, Kabupaten Nganjuk, Jawa Timur 64419"));
             googleMap.animateCamera(CameraUpdateFactory.newLatLng(SMA6));
             googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(SMA6,15));

             LatLng SMA7 = new LatLng(-7.612681, 111.917822);
             googleMap.addMarker(new MarkerOptions().position(SMA7).title("SMA Islam Insan Cendekia Baitul Izzah").snippet("Kendal, Kramat, Kec. Nganjuk, Kabupaten Nganjuk, Jawa Timur 64419"));
             googleMap.animateCamera(CameraUpdateFactory.newLatLng(SMA7));
             googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(SMA7,15));

             LatLng SMK1 = new LatLng(-7.604609, 111.895326);
             googleMap.addMarker(new MarkerOptions().position(SMK1).title("SMK Negeri 1 Nganjuk").snippet("Jl. DR. Soetomo, Kauman, Kec. Nganjuk, Kabupaten Nganjuk, Jawa Timur 64415"));
             googleMap.animateCamera(CameraUpdateFactory.newLatLng(SMK1));
             googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(SMK1,15));

             LatLng SMK2 = new LatLng(-7.611445, 111.913418);
             googleMap.addMarker(new MarkerOptions().position(SMK2).title("SMK Negeri 2 Nganjuk").snippet("Jl. Lawu No.3, Kramat, Kec. Nganjuk, Kabupaten Nganjuk, Jawa Timur 64419"));
             googleMap.animateCamera(CameraUpdateFactory.newLatLng(SMK2));
             googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(SMK2,15));

             LatLng SMK3 = new LatLng(-7.596264, 111.901889);
             googleMap.addMarker(new MarkerOptions().position(SMK3).title("SMK Muhammadiyah 1 Nganjuk").snippet("Jl. Citarum No.22-24, Mangundikaran, Mangun Dikaran, Kec. Nganjuk, Kabupaten Nganjuk, Jawa Timur 64411"));
             googleMap.animateCamera(CameraUpdateFactory.newLatLng(SMK3));
             googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(SMK3,15));

             LatLng SMK4 = new LatLng(-7.601176, 111.909145);
             googleMap.addMarker(new MarkerOptions().position(SMK4).title("SMK Muhammadiyah 2 Nganjuk").snippet("Jl. Veteran No.15, Mangundikaran, Ganung Kidul, Kec. Nganjuk, Kabupaten Nganjuk, Jawa Timur 64419"));
             googleMap.animateCamera(CameraUpdateFactory.newLatLng(SMK4));
             googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(SMK4,15));

             LatLng SMK5 = new LatLng(-7.596141, 111.901047);
             googleMap.addMarker(new MarkerOptions().position(SMK5).title("SMK Muhammadiyah 3 Nganjuk").snippet("Jalan Citarum No.24, Kauman, MangunDikaran, Kecamatan Nganjuk, Kabupaten Nganjuk, Jawa Timur 64411"));
             googleMap.animateCamera(CameraUpdateFactory.newLatLng(SMK5));
             googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(SMK5,15));

             LatLng SMK6 = new LatLng(-7.590739, 111.905058);
             googleMap.addMarker(new MarkerOptions().position(SMK6).title("SMK PGRI 1 Nganjuk").snippet("Jalan Barito N No.112, Kalianyar, Begadung, Kec. Nganjuk, Kabupaten Nganjuk, Jawa Timur 64413"));
             googleMap.animateCamera(CameraUpdateFactory.newLatLng(SMK6));
             googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(SMK6,15));

             LatLng SMK7 = new LatLng(-7.599171, 111.895587);
             googleMap.addMarker(new MarkerOptions().position(SMK7).title("SMK PGRI 2 Nganjuk").snippet("Jl. Abdul Rachman Saleh No.21, Kauman, Kauman, Nganjuk, Kabupaten Nganjuk, Jawa Timur 64411"));
             googleMap.animateCamera(CameraUpdateFactory.newLatLng(SMK7));
             googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(SMK7,15));

             LatLng SMK8 = new LatLng(-7.601716, 111.909071);
             googleMap.addMarker(new MarkerOptions().position(SMK8).title("SMK PGRI 3 Nganjuk").snippet("Jl. Veteran I No.16, Mangundikaran, Mangun Dikaran, Kec. Nganjuk, Kabupaten Nganjuk, Jawa Timur 64412"));
             googleMap.animateCamera(CameraUpdateFactory.newLatLng(SMK8));
             googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(SMK8,15));

             LatLng SMK9 = new LatLng(-7.600483, 111.899633);
             googleMap.addMarker(new MarkerOptions().position(SMK9).title("SMK dr. Soetomo Nganjuk").snippet("Jl. Jaksa Agung Suprapto No.2, Kauman, Kec. Nganjuk, Kabupaten Nganjuk, Jawa Timur 64411"));
             googleMap.animateCamera(CameraUpdateFactory.newLatLng(SMK9));
             googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(SMK9,15));

             LatLng SMK10 = new LatLng(-7.609128, 111.905112);
             googleMap.addMarker(new MarkerOptions().position(SMK10).title("SMK Kosgoro Nganjuk").snippet("Jl. Munginsidi No.78, Nganjuk, Payaman, Kec. Nganjuk, Kabupaten Nganjuk, Jawa Timur 64418"));
             googleMap.animateCamera(CameraUpdateFactory.newLatLng(SMK10));
             googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(SMK10,15));

             LatLng SMK11 = new LatLng(-7.615752, 111.905382);
             googleMap.addMarker(new MarkerOptions().position(SMK11).title("SMK Taruna Bakti Nganjuk").snippet("Jl. Imam Bonjol No.54, Payaman, Kec. Nganjuk, Kabupaten Nganjuk, Jawa Timur 64418"));
             googleMap.animateCamera(CameraUpdateFactory.newLatLng(SMK11));
             googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(SMK11,15));

             LatLng SMK12 = new LatLng(-7.598032, 111.914985);
             googleMap.addMarker(new MarkerOptions().position(SMK12).title("SMK Satria Bakti Nganjuk").snippet("Mangundikaran, Kec. Nganjuk, Kabupaten Nganjuk, Jawa Timur 64419"));
             googleMap.animateCamera(CameraUpdateFactory.newLatLng(SMK12));
             googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(SMK12,15));

             LatLng SMK13 = new LatLng(-7.610348, 111.906597);
             googleMap.addMarker(new MarkerOptions().position(SMK13).title("SMK Rudlototul Muslimin Nganjuk").snippet("JL. Imam Bonjol, Kel. Payaman, Kec. Nganjuk, Kabupaten Nganjuk, Jawa Timur 64484"));
             googleMap.animateCamera(CameraUpdateFactory.newLatLng(SMK13));
             googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(SMK13,15));
         }


     }
    //permisiion granted
     @Override
     public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
         switch (requestCode){
             case  REQUEST_CODE:
                 if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                     fetchLastLocation();
                 }
                 break;
         }
     }
 }
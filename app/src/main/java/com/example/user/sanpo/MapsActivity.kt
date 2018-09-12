package com.example.user.sanpo

import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.location.LocationProvider
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback,LocationListener {

    private lateinit var mMap: GoogleMap
    private lateinit var mlm:LocationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onStart() {
        super.onStart()
        mlm=getSystemService(Context.LOCATION_SERVICE)as LocationManager

        /**
        if (mlm.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            mlm.requestLocationUpdates(LocationManager.GPS_PROVIDER,1000,50f,this)
        }
        */
    }

    override fun onMapReady(googleMap: GoogleMap) {
        //mMap = googleMap

        /**
        val tokyo = LatLng(35.6811323,139.7670182)
        mMap.addMarker(MarkerOptions().position(tokyo).title("Tokyo"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tokyo,15f))
        */
    }

    override fun onStop() {
        super.onStop()
        mlm.removeUpdates(this)
    }

    override fun onLocationChanged(loc: Location?) {
        loc?.let{
            val position=LatLng(it.latitude,it.longitude)
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(position,15f))
        }
    }

    override fun onStatusChanged(p0: String?, status: Int, p2: Bundle?) {
        /**
        when(status){
            LocationProvider.AVAILABLE->{}
            LocationProvider.OUT_OF_SERVICE->{}
            LocationProvider.TEMPORARILY_UNAVAILABLE->{}
        }
        */
    }

    override fun onProviderDisabled(p0: String?) {

    }

    override fun onProviderEnabled(p0: String?) {

    }
}

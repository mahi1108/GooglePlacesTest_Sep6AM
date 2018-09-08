package cubex.mahesh.googleplacestest

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getLocation()
    }


    @SuppressLint("MissingPermission")
    fun  getLocation( )
    {
     var lManager =   getSystemService(Context.LOCATION_SERVICE)
                        as LocationManager
     lManager.requestLocationUpdates(
             LocationManager.NETWORK_PROVIDER,1000,
             1f, object : LocationListener {
                 override fun onLocationChanged(p0: Location?) {
                     var lati = p0!!.latitude
                     var longi = p0!!.longitude
                     tv1.text = lati.toString()
                     tv2.text = longi.toString()
                     lManager.removeUpdates(this)
                 }
                override fun onStatusChanged(p0: String?, p1: Int, p2: Bundle?) {
                 }
                 override fun onProviderEnabled(p0: String?) {
                 }
                 override fun onProviderDisabled(p0: String?) {
                 }
             })
    }

}

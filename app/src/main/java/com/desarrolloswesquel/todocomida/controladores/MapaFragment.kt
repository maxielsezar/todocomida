package com.desarrolloswesquel.todocomida.controladores

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.desarrolloswesquel.todocomida.R
import com.desarrolloswesquel.todocomida.databinding.FragmentMapaBinding
import com.desarrolloswesquel.todocomida.modelo.carga.CargarLocal
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions


class MapaFragment : Fragment(), OnMapReadyCallback, OnMarkerClickListener {

    private var _binding: FragmentMapaBinding? = null
    private lateinit var map: GoogleMap
    private val binding get() = _binding!!
    private val ListaLocales = CargarLocal().listaLocales()
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    companion object {
        const val REQUEST_CODE_LOCATION = 0
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMapaBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root

    }

    @SuppressLint("MissingPermission")
    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        localizacionActivada()
        //map.setMapStyle(MapStyleOptions.loadRawResourceStyle(R.raw.map_style)
        //map.setMapStyle(MapStyleOptions(resources.getString(R.string.style_json)))
        for (Local in ListaLocales) {
            map.addMarker(
                MarkerOptions()
                    .position(LatLng(Local.Latitud, Local.Longitud))
                    .title(Local.NombreLocal)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
            )
        }

        fusedLocationClient = context?.let { LocationServices.getFusedLocationProviderClient(it) }!!
        fusedLocationClient.lastLocation.addOnSuccessListener {
            if (it != null) {
                map.moveCamera(
                    CameraUpdateFactory.newLatLngZoom(
                        LatLng(
                            it.latitude,
                            it.longitude
                        ), 15f
                    )
                )
            }
        }
        map.setOnMarkerClickListener(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(this)

    }


    @SuppressLint("MissingPermission")
    override fun onMarkerClick(marker: Marker): Boolean {
        val locationA = Location("UbicacionActual")
        val locationB = Location("UbicacionLocal")
        locationB.latitude=marker.position.latitude
        locationB.longitude=marker.position.longitude
        fusedLocationClient = context?.let { LocationServices.getFusedLocationProviderClient(it) }!!
        fusedLocationClient.lastLocation.addOnSuccessListener {
            if (it != null) {
                locationA.latitude=it.latitude
                locationA.longitude=it.longitude
                val distance = locationA.distanceTo(locationB).toInt()
                Toast.makeText(context, "estas a ${distance} metros", Toast.LENGTH_SHORT).show()
            }
        }

        /*
        for (local in ListaLocales) {
            if (local.NombreLocal == marker.title) {
                val intent = Intent(context, LocalActivity::class.java)
                intent.putExtra("nombrelocal", local.NombreLocal)
                    .putExtra("rubrolocal", local.Rubro)
                    .putExtra("direccionlocal", local.DireccionLocal)
                    .putExtra("imagenlocal", local.ImagenLocal)
                    .putExtra("idLocal", local.IdLocal)
                startActivity(intent)
            }
        }*/
        return false
    }


    private fun permisosAceptados() =
        context?.let {
            ContextCompat.checkSelfPermission(
                it,
                Manifest.permission.ACCESS_FINE_LOCATION
            )
        } == PackageManager.PERMISSION_GRANTED

    private fun localizacionActivada() {
        if (!::map.isInitialized) return
        if (permisosAceptados()) {
            map.isMyLocationEnabled = true
        } else {
            pedirLocalizacionPermiso()
        }
    }

    private fun pedirLocalizacionPermiso() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(
                context as Activity,
                Manifest.permission.ACCESS_FINE_LOCATION
            )
        ) {
            Toast.makeText(context, "activa los permisos", Toast.LENGTH_SHORT).show()
        } else {
            ActivityCompat.requestPermissions(
                context as Activity,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                REQUEST_CODE_LOCATION
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            REQUEST_CODE_LOCATION -> if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                map.isMyLocationEnabled = true
            }
        }
    }
}
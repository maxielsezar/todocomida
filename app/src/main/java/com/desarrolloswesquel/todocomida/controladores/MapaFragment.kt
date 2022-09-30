package com.desarrolloswesquel.todocomida.controladores

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.desarrolloswesquel.todocomida.R
import com.desarrolloswesquel.todocomida.databinding.FragmentMapaBinding
import com.desarrolloswesquel.todocomida.modelo.carga.CargarLocal
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*


class MapaFragment : Fragment(), OnMapReadyCallback, OnMarkerClickListener {

    private var _binding: FragmentMapaBinding? = null
    private lateinit var map: GoogleMap
    private val binding get() = _binding!!
    private val ListaLocales = CargarLocal().listaLocales()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMapaBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root

    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap;
        //map.setMapStyle(MapStyleOptions.loadRawResourceStyle(R.raw.map_style)
        //map.setMapStyle(MapStyleOptions(resources.getString(R.string.style_json)))
        for (Local in ListaLocales) {
            map.addMarker(MarkerOptions()
                .position(LatLng(Local.Latitud, Local.Longitud))
                .title(Local.NombreLocal)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW))
            )
        }
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(-42.914147032096416, -71.32062964495022), 15f))
        map.setOnMarkerClickListener(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(this)

    }


    override fun onMarkerClick(marker: Marker): Boolean {
        for (local in ListaLocales) {
            if (local.NombreLocal == marker.title) {
                val intent = Intent(context, LocalActivity::class.java)
                intent.putExtra("nombrelocal", local.NombreLocal)
                    .putExtra("rubrolocal", local.Rubro)
                    .putExtra("direccionlocal", local.DireccionLocal)
                    .putExtra("imagenlocal", local.ImagenLocal)
                startActivity(intent)
            }
        }
        return false
    }
}

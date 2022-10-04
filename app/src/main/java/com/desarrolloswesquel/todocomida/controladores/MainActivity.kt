package com.desarrolloswesquel.todocomida.controladores

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.desarrolloswesquel.todocomida.R
import com.desarrolloswesquel.todocomida.databinding.ActivityMainBinding
import com.google.android.gms.maps.GoogleMap
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        navView.setupWithNavController(navController)

        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
            MapaFragment.REQUEST_CODE_LOCATION
        )
    }

}


package com.desarrolloswesquel.todocomida.controladores

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.desarrolloswesquel.todocomida.R
import com.desarrolloswesquel.todocomida.databinding.LoginActivityBinding


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: LoginActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = LoginActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.IngresarEmail.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}


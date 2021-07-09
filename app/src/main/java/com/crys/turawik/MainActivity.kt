package com.crys.turawik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.crys.turawik.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Turawik)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
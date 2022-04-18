package com.example.hw_5_fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hw_5_fragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.activity_frame_layout, ContactList())
            .commit()
    }
}
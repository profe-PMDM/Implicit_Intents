package es.jesuitas.dam.implicitintents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import es.jesuitas.dam.implicitintents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}
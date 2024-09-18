package com.example.vitalium

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResumenActivity : AppCompatActivity() {

    private lateinit var totalTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumen)

        // Encuentra el TextView por su ID
        totalTextView = findViewById(R.id.totalTextView)

        // Configura el texto del TextView
        val total = 123.45 // Ejemplo de valor
        totalTextView.text = "Total: $total"
        }
}

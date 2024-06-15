package com.example.tecno_total_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ProductoActivity : AppCompatActivity() {

    private lateinit var description: TextView
    private lateinit var imagen: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producto)

        description = findViewById(R.id.textDescripcion)
        imagen = findViewById(R.id.imagenProducto)

        val id = intent.getIntExtra("id", 0)
        val nombre = intent.getStringExtra("nombre")
        val marca = intent.getStringExtra("marca")
        val precio = intent.getDoubleExtra("precio", 0.0)
        val imagenRes = intent.getIntExtra("imagen", 0)

        description.text = "Nombre del Producto: ${nombre}\n\n" +
                "Marca del producto: ${marca}\n\n" +
                "Precio del producto: $${precio}"
        imagen.setImageResource(imagenRes)

    }
}
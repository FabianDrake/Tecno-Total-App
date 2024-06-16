package com.example.tecno_total_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class ProductoActivity : AppCompatActivity() {

    private lateinit var description: TextView
    private lateinit var imagen: ImageView
    private lateinit var btnAddToCart: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producto)

        description = findViewById(R.id.textDescripcion)
        imagen = findViewById(R.id.imagenProducto)
        btnAddToCart = findViewById(R.id.btnAddToCart)

        val id = intent.getIntExtra("id", 0)
        val nombre = intent.getStringExtra("nombre")
        val marca = intent.getStringExtra("marca")
        val precio = intent.getDoubleExtra("precio", 0.0)
        val imagenRes = intent.getIntExtra("imagen", 0)

        description.text = "Nombre del Producto: ${nombre}\n\n" +
                "Marca del producto: ${marca}\n\n" +
                "Precio del producto: $${precio}"
        imagen.setImageResource(imagenRes)

        val producto = Producto(id, nombre!!, marca!!, precio, imagenRes)

        btnAddToCart.setOnClickListener {
            Cart.agregarProducto(producto)
            Toast.makeText(this, "Producto añadido al carrito", Toast.LENGTH_SHORT).show()
        }
    }
}
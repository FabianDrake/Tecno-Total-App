package com.example.tecno_total_app

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.ImageView
import androidx.fragment.app.Fragment

class ProductsFragment : Fragment() {
    private val products = arrayOf(
        Producto(0, "Producto 0", "Marca 0", 10.0),
        Producto(1, "Producto 1", "Marca 1", 20.0),
        Producto(2, "Producto 2", "Marca 2", 30.0),
        Producto(3, "Producto 3", "Marca 3", 40.0),
        Producto(4, "Producto 4", "Marca 4", 50.0),
        Producto(5, "Producto 5", "Marca 5", 60.0),
        Producto(6, "Producto 6", "Marca 6", 70.0),
        Producto(7, "Producto 7", "Marca 7", 80.0),
        Producto(8, "Producto 8", "Marca 8", 90.0),
        Producto(9, "Producto 9", "Marca 9", 100.0)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_products, container, false)
        val productsLayout: GridLayout = view.findViewById(R.id.products_layout)

        // Aquí puedes añadir el código para mostrar los productos en productsLayout
        // y manejar los clics en los productos.

        return view
    }

    private fun startProductoActivity(producto: Producto) {
        val intent = Intent(context, ProductoActivity::class.java).apply {
            putExtra("id", producto.id)
            putExtra("nombre", producto.nombre)
            putExtra("marca", producto.marca)
            putExtra("precio", producto.precio)
        }
        startActivity(intent)
    }
}
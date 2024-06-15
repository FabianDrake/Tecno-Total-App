package com.example.tecno_total_app

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment

class ProductsFragment : Fragment() {
    private val products = arrayOf(
        Producto(0, "Tarjeta Grafica RTX", "Nvidia", 3000.00, R.drawable.img1),
        Producto(1, "Mouse Gamer Alambrico", "Logitech", 800.00, R.drawable.img2),
        Producto(2, "Teclado Negro", "Crucial", 300.00,R.drawable.img3),
        Producto(3, "Gabinete con luz led", "Aourus Gaming", 4000.00, R.drawable.img4),
        Producto(4, "Monitor 144hz", "Gigabyte", 6000.00, R.drawable.img5),
        Producto(5, "Motherboard Gamer", "Aourus Gaming", 1500.00, R.drawable.img6),
        Producto(6, "Duo tarjetas RAM", "Fury Gaming", 1200.00, R.drawable.img7),
        Producto(7, "SSD m.2 500GB", "Crucial", 800.00, R.drawable.img8),
        Producto(8, "Tableta de dibujo", "Crucial", 9000.00, R.drawable.img9),
        Producto(9, "Auriculares con microfono Gamer", "Onikuma", 500.00, R.drawable.img10)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_products, container, false)
        val productsLayout: GridLayout = view.findViewById(R.id.products_layout)

        for (i in 0 until productsLayout.childCount) {
            val constraintLayout = productsLayout.getChildAt(i)
            if (constraintLayout is ConstraintLayout) {
                val imageView = constraintLayout.getChildAt(0)
                if (imageView is ImageView) {
                    imageView.setOnClickListener {
                        startProductoActivity(products[i])
                    }
                }
            }
        }

        return view
    }

    private fun startProductoActivity(producto: Producto) {
        val intent = Intent(context, ProductoActivity::class.java).apply {
            putExtra("id", producto.id)
            putExtra("nombre", producto.nombre)
            putExtra("marca", producto.marca)
            putExtra("precio", producto.precio)
            putExtra("imagen", producto.imagen)
        }
        startActivity(intent)
    }
}
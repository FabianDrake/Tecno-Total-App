package com.example.tecno_total_app

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CartFragment : Fragment() {

    private lateinit var recyclerViewCart: RecyclerView
    private lateinit var tvTotalPrice: TextView
    private lateinit var btnPagar: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cart, container, false)

        recyclerViewCart = view.findViewById<RecyclerView>(R.id.recyclerViewCart)
        tvTotalPrice = view.findViewById<TextView>(R.id.tvTotalPrice)
        btnPagar = view.findViewById<Button>(R.id.btnPagar)
        recyclerViewCart.layoutManager = LinearLayoutManager(context)

        Cart.productos.observe(viewLifecycleOwner, Observer { productos ->
            recyclerViewCart.adapter = CartAdapter(productos)

            val total = productos.sumByDouble { it.precio }
            tvTotalPrice.text = "Total: $${"%.2f".format(total)}"
        })

        btnPagar.setOnClickListener {
            Cart.limpiarCarrito()
            Toast.makeText(context, "Pago realizado, el carrito ha sido vaciado", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}
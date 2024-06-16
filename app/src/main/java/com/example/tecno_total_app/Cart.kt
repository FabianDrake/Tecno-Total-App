package com.example.tecno_total_app

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

object Cart {
    val productos = MutableLiveData<MutableList<Producto>>()

    fun agregarProducto(producto: Producto) {
        val currentProducts = productos.value ?: mutableListOf()
        currentProducts.add(producto)
        productos.value = currentProducts
    }

    fun limpiarCarrito() {
        productos.value = mutableListOf()
    }
}
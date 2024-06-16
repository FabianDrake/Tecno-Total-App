package com.example.tecno_total_app

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class Cart {
    companion object {
        private val _productos = MutableLiveData<List<Producto>>(emptyList())
        val productos: LiveData<List<Producto>> get() = _productos

        fun agregarProducto(producto: Producto) {
            val newList = _productos.value.orEmpty().toMutableList()
            newList.add(producto)
            _productos.value = newList
        }
    }
}
package com.example.tecno_total_app

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var usernameField: EditText
    private lateinit var passwordField: EditText

    val usuarios = arrayOf(
        Usuario("Fabian", "1234"),
        Usuario("Soto", "1234"),
        Usuario("Axel", "1234"),
        Usuario("Pancho", "1234"),
        Usuario("Lalo", "1234")
    )

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        usernameField = findViewById(R.id.username_field)
        passwordField = findViewById(R.id.password_field)

        val loginButton: Button = findViewById(R.id.login_button)
        loginButton.setOnClickListener {
            val username = usernameField.text.toString()
            val password = passwordField.text.toString()

            if (usuarios.any { it.username == username && it.password == password }) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Nombre de usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
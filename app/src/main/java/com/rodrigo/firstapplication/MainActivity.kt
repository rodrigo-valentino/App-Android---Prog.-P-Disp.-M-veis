package com.rodrigo.firstapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rodrigo.firstapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        enableEdgeToEdge()
        setContentView(view)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Referências dos campos e do botão definidos no layout XML
        val editTextEmail = binding.editText
        val editTextPassword = binding.editTextPassword
        val button = binding.button

        // Ao clicar no botão, lê o e-mail e a senha e mostra em um Toast
        button.setOnClickListener {
            val email = editTextEmail.text.toString()
            val senha = editTextPassword.text.toString()

            Toast.makeText(
                this,
                "Email: $email\nSenha: $senha",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}

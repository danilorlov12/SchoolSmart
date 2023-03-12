package com.example.schoolsmart.presentation.login

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.schoolsmart.base.BaseActivity
import com.example.schoolsmart.databinding.AuthActivityBinding
import com.example.schoolsmart.domain.entities.UserType
import com.example.schoolsmart.presentation.director.DirectorActivity

class AuthActivity : BaseActivity<AuthActivityBinding>(AuthActivityBinding::inflate) {

    private val viewModel: AuthViewModel by lazy {
        ViewModelProvider(this)[AuthViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loggedUser.observe(this) { user ->
            Toast.makeText(this, "$user", Toast.LENGTH_SHORT).show()
            when (user) {
                UserType.DIRECTOR -> {
                    val intent = Intent(this, DirectorActivity::class.java)
                    startActivity(intent)
                }
                UserType.TEACHER -> {

                }
                UserType.SCHOOL_MEMBER -> {

                }
                else -> return@observe
            }
        }
        binding.etUsername.setText("danil.orlov.3022013@gmail.com")
        binding.etPassword.setText("zooming4421")

        binding.btnLogin.setOnClickListener {
            val email = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()

            if (validateEmail(email) && validatePassword(password)) {
                viewModel.login(email, password)
            }
        }
    }

    private fun validateEmail(email: String): Boolean {
        binding.tilUsername.error = when {
            email.isEmpty() -> "Is Empty"
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> "Wrong"
            else -> null
        }
        return binding.tilUsername.error == null
    }

    private fun validatePassword(password: String): Boolean {
        binding.tilPassword.error = when {
            password.isEmpty() -> "Is Empty"
            password.length < 3 -> "Password should be at least 4 characters long"
            else -> null
        }
        return binding.tilPassword.error == null
    }
}
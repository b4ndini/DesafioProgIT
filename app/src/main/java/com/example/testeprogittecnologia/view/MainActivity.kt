package com.example.testeprogittecnologia.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import com.example.testeprogittecnologia.databinding.ActivityMainBinding
import com.example.testeprogittecnologia.util.MaskWatcher
import com.example.testeprogittecnologia.util.validateCPF
import com.example.testeprogittecnologia.util.validateEmail

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setPhoneAndCpfMask()
        setTextWatcher()
        binding.btnRegister.setOnClickListener {
            register()
        }

    }

    private fun setPhoneAndCpfMask() {
        binding.etPhone.addTextChangedListener(MaskWatcher.mask("(##) #####-####", binding.etPhone))
        binding.etCPF.addTextChangedListener(MaskWatcher.mask("###.###.###-##", binding.etCPF))
    }

    private val registerTextWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            disableErrorState()
        }

        override fun afterTextChanged(p0: Editable?) {

        }

    }

    private fun setTextWatcher() {
        binding.etName.addTextChangedListener(registerTextWatcher)
        binding.etCPF.addTextChangedListener(registerTextWatcher)
        binding.etEmail.addTextChangedListener(registerTextWatcher)
        binding.etPhone.addTextChangedListener(registerTextWatcher)
        binding.etPassword.addTextChangedListener(registerTextWatcher)
        binding.etRepeatPassword.addTextChangedListener(registerTextWatcher)
    }

    private fun register() {

        val name = binding.etName.text.toString()
        val cpf = binding.etCPF.text.toString()
        val phone = binding.etPhone.text.toString()
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()
        val repeatPassword = binding.etRepeatPassword.text.toString()


        when {
            !cpf.validateCPF() -> binding.tilCPF.error = "CPF inválido"
            name.isBlank() || name.length <= 10 -> binding.tilName.error = "Nome inválido"
            !email.validateEmail() -> binding.tilEmail.error = "E-mail inválido"
            phone.isEmpty() || phone.length < 15 -> binding.tilPhone.error = "Número inválido"
            password.isEmpty() || password.isBlank() -> binding.tilPassword.error = "Senha inválida"
            password != repeatPassword -> binding.tilRepeatPassword.error =
                "As senhas não coincidem"
            else -> {
                Toast.makeText(
                    this,
                    "Cadastro realizado com sucesso, confira abaixo suas informações:\n\n" +
                            "CPF: $cpf\nNome: $name\nE-mail: $email\nTelefone: $phone",
                    Toast.LENGTH_LONG
                ).show()
                val intent = Intent(this, ResultActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun disableErrorState() {
        binding.tilName.isErrorEnabled = false
        binding.tilCPF.isErrorEnabled = false
        binding.tilEmail.isErrorEnabled = false
        binding.tilPhone.isErrorEnabled = false
        binding.tilPassword.isErrorEnabled = false
        binding.tilRepeatPassword.isErrorEnabled = false
    }


}
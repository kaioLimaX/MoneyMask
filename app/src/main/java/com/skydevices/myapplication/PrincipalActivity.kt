package com.skydevices.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.skydevices.easymanager.helper.MaskMoney
import com.skydevices.myapplication.databinding.ActivityPrincipalBinding
import java.util.Locale


class PrincipalActivity : AppCompatActivity() {

    val binding by lazy {
        ActivityPrincipalBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        inicializarComponentes()

        with(binding){
            btnCapturar.setOnClickListener {
                recuperarResultado()
            }
        }
    }

    private fun recuperarResultado() {
        if(binding.edtValor.text?.isNotEmpty() == true){
        val valorNumericoString: String =
            binding.edtValor.text!!.replace("[^\\d,]".toRegex(), "").replace(".", "").replace(",", ".")
        val valorNumerico = valorNumericoString.toDouble()
        binding.txtResultado.text = valorNumerico.toString()}else{
            Toast.makeText(this, "insira algo diferente de 0", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inicializarComponentes() {
        val mLocale = Locale("pt", "BR")
        val editValor  = binding.edtValor
        editValor.addTextChangedListener(MaskMoney(editValor, mLocale))
    }
}
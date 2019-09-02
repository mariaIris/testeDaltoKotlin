package com.example.testedaltonismo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val params = intent.extras
        var codImagem = params?.getInt("codImagem")


        when(codImagem){
            1->imageView.setImageResource(R.drawable.image1)
            2->imageView.setImageResource(R.drawable.image2)
            3->imageView.setImageResource(R.drawable.image3)
        }

        cancelarButton.setOnClickListener{
            setResult(Activity.RESULT_CANCELED)
            finish()
        }

        confirmarButton.setOnClickListener {
            var i = Intent()
            i.putExtra("DADOS_RESPOSTA", numeroDado.text.toString())
            setResult(Activity.RESULT_OK, i)
            finish()
        }
    }
}

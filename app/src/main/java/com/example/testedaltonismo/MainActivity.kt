package com.example.testedaltonismo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var REQUESTCODE1 = 88
    var REQUESTCODE2 = 89
    var REQUESTCODE3 = 90

    var result1:Int? = 0;
    var result2:Int? = 0;
    var result3:Int? = 0;

    var resultFinal = "Faça o teste"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resp1.text = ("$result1")
        resp2.text = ("$result2")
        resp3.text = ("$result3")

        resultTexto.text = ("resultFinal")

    }

    fun click(v:View){
        var codImagem = 0
        var codRequest = 0

        when(v.id){
            R.id.button1->{
                codImagem = 1
                codRequest = REQUESTCODE1
            }
            R.id.button2->{
                codImagem = 2
                codRequest = REQUESTCODE2
            }
            R.id.button3->{
                codImagem = 3
                codRequest = REQUESTCODE3
            }
        }

        var i = Intent (this,Main2Activity::class.java)
        var param = Bundle()
        param.putInt("codImagem",codImagem)
        i.putExtras(param)
        startActivityForResult(i,codRequest)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when(requestCode){
            REQUESTCODE1 ->{
                when(requestCode){
                    Activity.RESULT_OK->{
                        result1 = data?.getStringExtra("resposta")?.toInt()
                        resp1.text="$result1"
                    }
                    Activity.RESULT_CANCELED->{
                        Toast.makeText(this,"CANCELADO",Toast.LENGTH_SHORT).show()
                    }
                }
            }
            REQUESTCODE2 ->{
                when(requestCode){
                    Activity.RESULT_OK->{
                        result2 = data?.getStringExtra("resposta")?.toInt()
                        resp2.text="$result2"
                    }
                    Activity.RESULT_CANCELED->{
                        Toast.makeText(this,"CANCELADO",Toast.LENGTH_SHORT).show()
                    }
                }
            }
            REQUESTCODE3->{
                when(requestCode){
                    Activity.RESULT_OK->{
                        result3 = data?.getStringExtra("resposta")?.toInt()
                        resp3.text="$result3"
                    }
                    Activity.RESULT_CANCELED->{
                        Toast.makeText(this,"CANCELADO",Toast.LENGTH_SHORT).show()
                    }
                }
            }

        }
    }
}

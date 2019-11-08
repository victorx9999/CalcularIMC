package com.example.imc

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    var isFragmentOneLoaded = true
    var isFragmentTwoLoaded = true
    var isFragmentThreeLoaded = true
    val manager = supportFragmentManager

    private lateinit var tvValor: TextView
    private lateinit var tvMsg: TextView

    private lateinit var botao: Button
    private lateinit var btnVoltar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result_activity)

        this.botao = findViewById(R.id.btIDResult)
        this.tvValor = findViewById(R.id.tvFragValor)
        this.tvMsg = findViewById(R.id.tvFragMsg)
        this.btnVoltar = findViewById(R.id.btnVoltar)

        this.botao.setOnClickListener({ onClick(it) })
        this.btnVoltar.setOnClickListener({ onClickVoltar() })

//       val mensagem = intent.getStringExtra("DADOS").

//        val pessoas = intent.getSerializableExtra("DADOS") as ArrayList<*>


        //       Toast.makeText(this, dados, Toast.LENGTH_SHORT).show()
        ///////////////////////////////////////////////////////////////////////

//        val Change = findViewById<Button>(R.id.btIDResult)
//
//        Change.setOnClickListener {
//            ShowFragmentOne()
//            var dados = intent.getSerializableExtra("DADOS").toString()
//
//            if(dados.toDouble() < 18.5){
//                idTeste.text = "ABAIXO DO PESO"
//            }else if(dados.toDouble() < 24.9){
//                idTeste.text = "PESO IDEAL"
//            }else {
//                idTeste.text = "PORRA FUNCIONA MIZERA"
//            }
//            //idTeste.text = String.format(Locale.US, "%.2f", dados)
//
//        }

//        Change2.setOnClickListener{
//            ShowFragmentTwo()
//        }
//
//        Change3.setOnClickListener{
//            ShowFragmentThree()}

    }


    fun onClick(view: View) {
        ShowFragmentOne()
        /* var dados = intent.getSerializableExtra("DADOS").toString()


        }*/
    }

    fun ShowFragmentOne() {
        val transaction = manager.beginTransaction()
        val fragment = FragmentOne()

        var dados = intent.getSerializableExtra("DADOS").toString()

       //  dados =   String.format(Locale.US,"%0.2")


        val data = Bundle()

  //      tvValor.text = dados;

   //     tvValor.text = String.format(Locale.US,"%0.2",dados)

  //       tvMsg.text = (String.format(Locale.US, "%.2f"))

        if (dados.toDouble() < 18.5) {
            tvMsg.text = "ABAIXO DO PESO"
        } else if (dados.toDouble() < 24.9) {
            tvMsg.text = "PESO IDEAL"
        } else if (dados.toDouble() < 29.9) {
            tvMsg.text = "SOBREPESO"
        } else if (dados.toDouble() < 34.9) {
            tvMsg.text = "Obesidade Grau I"
        } else if (dados.toDouble() < 39.9) {
            tvMsg.text = "Obesidade Grau II"
        } else {
            tvMsg.text = "Obesidade Grau III"
        }


        data.putString("DADOS", dados)

        fragment.arguments = data


        transaction.replace(R.id.fragment_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragmentOneLoaded = true

    }


    fun onClickVoltar() {
        finish()
    }

}
package com.example.imc

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class FormActivity : AppCompatActivity() {
    private lateinit var btSalvar: Button
    private lateinit var btCancelar: Button
    private lateinit var etNome: EditText
    private lateinit var etIdade: EditText
    private lateinit var etPeso: EditText
    private lateinit var etAltura: EditText
    val SECOND = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        this.btSalvar = findViewById(R.id.btFormSalvar)
        this.btCancelar = findViewById(R.id.btFormCancelar)


        this.etNome = findViewById(R.id.etFormNome)
        this.etIdade = findViewById(R.id.etFormIdade)
        this.etPeso = findViewById(R.id.etFormPeso)
        this.etAltura = findViewById(R.id.etFormAltura)

        this.btSalvar.setOnClickListener({ clickSalvar(it) })

        this.btCancelar.setOnClickListener({
            finish()
        })

//               EDIÇÃO
//        var pessoa = intent.getSerializableExtra("PESSOA")

//        if (pessoa != null){
//            // veio amigo, ou seja, é edição
//            this.etNome.text.append((pessoa as Pessoa).nome)
//            this.etNome.text.append((pessoa as Pessoa).nome)
//            this.etNome.text.append((pessoa as Pessoa).nome)
//            this.etNome.text.append((pessoa as Pessoa).nome)
//        }
    }

    fun clickSalvar(view: View){
//        val nome = this.etNome.text.toString()
//        val idade = this.etNome.text.toString().toInt()
//        val peso = this.etNome.text.toString().toDouble()
//        val altura = this.etNome.text.toString().toInt()
//        val pessoa = Pessoa(nome, idade, peso, altura)

        val nome = this.etNome.text.toString()
        val idade = this.etIdade.text.toString().toInt()
        val peso = this.etPeso.text.toString().toDouble()
        val altura = this.etAltura.text.toString().toInt()

        val pessoa = Pessoa(nome, idade, peso, altura)

        val itVolta = Intent()
        itVolta.putExtra("PESSOA", pessoa)
        setResult(Activity.RESULT_OK, itVolta)
     //   finish()

        val imcValue = (((peso/(altura*altura)) * 10000))

        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("DADOS", imcValue)

        startActivity(intent)
        finish()

    }

}

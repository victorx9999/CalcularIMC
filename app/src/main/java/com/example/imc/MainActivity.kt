package com.example.imc

import android.app.Activity
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.*

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val FORMULARIO_ADD = 1
    val FORMULARIO_EDIT = 2
    var POSITION_EDIT = -1
    private lateinit var lista: ArrayList<Pessoa>
    private lateinit var lvAmigos: ListView
    private lateinit var dao : PessoaDAO
    private lateinit var telaReceiver: TelaReceiver


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        this.telaReceiver = TelaReceiver()


        fab.setOnClickListener { view ->
            val itForm = Intent(this, FormActivity::class.java)
            startActivityForResult(itForm, FORMULARIO_ADD)
        }

        this.dao = PessoaDAO(this)
        this.lista = arrayListOf()
        this.lvAmigos = findViewById(R.id.lvMainAmiguinhos)
        this.lvAmigos.setOnItemClickListener(ClickList())
        this.lvAmigos.setOnItemLongClickListener(LongClickList())

        this.dao.insert(Pessoa("Teste 1", 1, 1.1, 1))
//        this.lista.add(Pessoa("Teste 2", 2, 1.2, 1))
//        this.lista.add(Pessoa("Teste 3", 3, 1.3, 1))
//        this.lista.add(Pessoa("Teste 4", 5, 1.4, 1))
        this.dao = PessoaDAO(this)
        this.lista = this.dao.get()
        Log.i("APP_BANCO", lista.toString())


        this.lvAmigos.adapter = PessoaAdapter(this, this.lista)

//        this.lvAmigos.adapter = ArrayAdapter<Pessoa>(this, android.R.layout.simple_list_item_1, this.lista)
//        atualizaLista()

    }

    override fun onResume() {
        super.onResume()

        val itfTela = IntentFilter()
        itfTela.addAction(Intent.ACTION_USER_PRESENT)
        registerReceiver(this.telaReceiver, itfTela)
    }

    fun update(){
        this.lista.clear()
        this.lista.addAll(this.dao.get())
        (this.lvAmigos.adapter as PessoaAdapter).update()
    }
//    fun atualizaLista(){
//        (this.lvAmigos.adapter as ArrayAdapter<Pessoa>).notifyDataSetChanged()
//        this.lista.clear()
//        this.lista.addAll(this.dao.get())
//
//        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, this.lista)
//
//        adapter.notifyDataSetChanged()
//    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK){
            if (requestCode == FORMULARIO_ADD){
                val pessoa = data?.getSerializableExtra("PESSOA") as Pessoa
                this.dao.insert(pessoa)
  //              this.atualizaLista()
                this.update()
                Log.i("APP_BANCO", this.dao.get().toString())
            }
        }
    }

    inner class ClickList : AdapterView.OnItemClickListener{
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            val pessoa = this@MainActivity.lista[position]
            val itForm = Intent(this@MainActivity, FormActivity::class.java)
            //Toast.makeText(this@MainActivity, amigo.toString(), Toast.LENGTH_SHORT).show()
            itForm.putExtra("PESSOA", pessoa)
            this@MainActivity.POSITION_EDIT = position
            startActivityForResult(itForm, FORMULARIO_EDIT)
        }
    }

    inner class LongClickList : AdapterView.OnItemLongClickListener{
        override fun onItemLongClick(
            parent: AdapterView<*>?,
            view: View?,
            position: Int,
            id: Long
        ): Boolean {
            val pessoa = this@MainActivity.lista.get(position)
            this@MainActivity.lista.removeAt(position)
  //          this@MainActivity.atualizaLista()
            this@MainActivity.dao.delete(pessoa.id)
            this@MainActivity.update()

            return true
        }

    }

}

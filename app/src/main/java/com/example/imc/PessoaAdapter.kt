package com.example.imc

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class PessoaAdapter(var context: Context, var listPessoas: ArrayList<Pessoa>)  : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var layout: View
        val pessoa = this.listPessoas.get(position)

        if (convertView == null){
            var inflater = this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            layout = inflater.inflate(R.layout.pessoa_layout, null)
        }else{
            layout = convertView
        }

        val tv = layout.findViewById<TextView>(R.id.tvPessoaNome)
        tv.text = pessoa.nome

        if (position % 2 == 0)
            layout.setBackgroundColor(Color.rgb	(0,191,255))
        else
            layout.setBackgroundColor(Color.rgb(100,149,237))


        return layout
    }

    override fun getItem(position: Int): Any {
        return this.listPessoas.get(position)
    }

    override fun getItemId(position: Int): Long {
        return -1
    }

    override fun getCount(): Int {
        return this.listPessoas.count()
    }

    fun update(){
        notifyDataSetChanged()
    }
}
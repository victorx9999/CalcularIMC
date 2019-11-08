package com.example.imc

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

  class Fragment : Fragment() {

    val TAG = "FragmentOne"
    override fun onAttach(context: Context) {
        Log.d(TAG,"onAttach")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG,"onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_one,container,false)

        val texto = view.findViewById<TextView>(R.id.textViewOne)


        val getArgument = arguments!!.getString("DADOS")

        texto.text = getArgument

        //  Log.d(TAG,"onCreateView")
        // return inflater!!.inflate(R.layout.fragment_one,container,false)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d(TAG,"onActivityCreated")
        super.onActivityCreated(savedInstanceState)
    }

}
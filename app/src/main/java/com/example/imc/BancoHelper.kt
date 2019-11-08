package com.example.imc

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
// nome: String, idade: Int, peso: Double, altura: Int
class BancoHelper(context: Context): SQLiteOpenHelper(context, "banco.db", null, 1){

    override fun onCreate(db: SQLiteDatabase?) {
        val sql = "create table if not exists pessoas (" +
                " id integer primary key autoincrement," +
                " nome text," +
                " idade integer," +
                " peso double,"+
                " altura integer" +
                ")"

        db?.execSQL(sql)
    }
    override fun onUpgrade(db: SQLiteDatabase?, before: Int, actual: Int) {
        db?.execSQL("drop table pessoas")
        this.onCreate(db)
    }
}
package com.example.imc

import java.io.Serializable

class Pessoa : Serializable {
    var id: Int
    var nome: String
    var idade: Int
    var peso: Double
    var altura: Int


    constructor(nome: String, idade: Int, peso: Double, altura: Int){
        this.id = -1
        this.nome = nome
        this.idade = idade
        this.peso = peso
        this.altura = altura
    }

    constructor(id: Int, nome: String, idade: Int, peso: Double, altura: Int){
        this.id = id
        this.nome = nome
        this.idade = idade
        this.peso = peso
        this.altura = altura
    }

    override fun toString(): String {
        return "${nome} {Idade: ${idade} - Altura: ${altura} - Peso: ${peso}}"
    }
}
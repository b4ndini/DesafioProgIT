package com.example.testeprogittecnologia.model

data class Data(
    val DataSorteio: String,
    val IdSorteio: Int,
    var Premios: List<Premio>,
    val TipoMatrizSorteio: Int
)
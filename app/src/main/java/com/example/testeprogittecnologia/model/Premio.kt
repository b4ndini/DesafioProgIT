package com.example.testeprogittecnologia.model

data class Premio(
    val Contemplados: List<Contemplado>,
    val Descricao: String,
    val Destaque: Boolean,
    val IdPremio: Int,
    val Imagem: Any,
    val OrdemExibicao: Int,
    val OrdemSorteio: Int
)
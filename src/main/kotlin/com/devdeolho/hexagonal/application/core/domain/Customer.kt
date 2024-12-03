package com.devdeolho.hexagonal.application.core.domain

data class Customer(
/*
    val == immutable java
    var == mutable java
*/
    val id: String? = null,
    val name: String,
    var address:Address? = null,
    val cpf: String,
    val isValidCpf: Boolean = false
)

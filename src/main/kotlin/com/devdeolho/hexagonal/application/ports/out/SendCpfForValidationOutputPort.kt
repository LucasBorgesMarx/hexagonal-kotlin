package com.devdeolho.hexagonal.application.ports.out

interface SendCpfForValidationOutputPort {
    fun send(cpf: String)
}
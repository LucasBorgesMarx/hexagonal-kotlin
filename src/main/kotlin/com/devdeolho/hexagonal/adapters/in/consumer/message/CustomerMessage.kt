package com.devdeolho.hexagonal.adapters.`in`.consumer.message

import com.devdeolho.hexagonal.application.core.domain.Customer

data class CustomerMessage(
    val id: String = "",
    val name: String = "",
    val zipCode: String = "",
    val cpfNumber: String = "",
    val isValidCpf: Boolean = false
) {
    fun toCustomer() = createCustomer(id, name, cpfNumber, isValidCpf)

    private fun createCustomer(id: String, name: String, cpfNumber: String, isValidCpf: Boolean) = Customer(
        id = id,
        name = name,
        cpf = cpfNumber,
        isValidCpf = isValidCpf
    )
}
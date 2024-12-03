package com.devdeolho.hexagonal.adapters.`in`.controller.response

import com.devdeolho.hexagonal.application.core.domain.Customer


data class CustomerResponse(
    val id: String,
    val name: String,
    val cpf: String,
    val address: AddressResponse,
    val isValidCpf: Boolean
) {
    constructor(customer: Customer) : this(
        customer.id!!,
        customer.name,
        customer.cpf,
        AddressResponse(customer.address!!),
        customer.isValidCpf
    )

    companion object {
        fun fromCustomers(customers: List<Customer>): List<CustomerResponse> = customers.map { customer ->
            CustomerResponse(customer)
        }
    }
}
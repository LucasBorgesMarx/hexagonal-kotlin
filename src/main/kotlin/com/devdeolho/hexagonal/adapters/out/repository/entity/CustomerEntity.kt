package com.devdeolho.hexagonal.adapters.out.repository.entity

import com.devdeolho.hexagonal.application.core.domain.Customer
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.MongoId

@Document(collection = "customers")
data class CustomerEntity(

    @MongoId
    val id: String?,
    val name: String,
    var address: AddressEntity,
    val cpf: String,
    val isValidCpf: Boolean
) {
    /*
        O operador (!!) em kotlin indica que o valor não pode ser nulo
    */
    constructor(customer: Customer) :
            this(customer.id, customer.name, AddressEntity(customer.address!!), customer.cpf, customer.isValidCpf)

    fun toCustomer() =
        Customer(
            id,
            name,
            address.toAddress(),
            cpf,
            isValidCpf
        )
}




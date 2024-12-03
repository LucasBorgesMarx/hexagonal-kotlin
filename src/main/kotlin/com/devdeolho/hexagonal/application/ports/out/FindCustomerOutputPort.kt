package com.devdeolho.hexagonal.application.ports.out

import com.devdeolho.hexagonal.application.core.domain.Customer

interface FindCustomerOutputPort {
    /*
     ? Indica que o retorno pode ser nulo
    */
    fun find(id: String): Customer?
    fun findAll(): List<Customer>
}
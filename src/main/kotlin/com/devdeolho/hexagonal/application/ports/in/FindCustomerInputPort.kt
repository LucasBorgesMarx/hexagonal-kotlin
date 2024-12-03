package com.devdeolho.hexagonal.application.ports.`in`

import com.devdeolho.hexagonal.application.core.domain.Customer

interface FindCustomerInputPort {
    fun find(id: String): Customer
    fun findAll(): List<Customer>
}
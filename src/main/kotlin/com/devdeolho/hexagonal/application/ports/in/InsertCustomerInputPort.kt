package com.devdeolho.hexagonal.application.ports.`in`

import com.devdeolho.hexagonal.application.core.domain.Customer

interface InsertCustomerInputPort {
    fun insert(customer: Customer, zipCode: String)
}
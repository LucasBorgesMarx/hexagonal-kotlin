package com.devdeolho.hexagonal.application.ports.out

import com.devdeolho.hexagonal.application.core.domain.Customer

interface InsertCustomerOutputPort {
    fun insert(customer: Customer)
}
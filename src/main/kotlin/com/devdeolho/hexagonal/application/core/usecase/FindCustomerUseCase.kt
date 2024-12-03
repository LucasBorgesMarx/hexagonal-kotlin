package com.devdeolho.hexagonal.application.core.usecase

import com.devdeolho.hexagonal.application.core.domain.Customer
import com.devdeolho.hexagonal.application.core.exceptions.ObjectNotFoundException
import com.devdeolho.hexagonal.application.ports.`in`.FindCustomerInputPort
import com.devdeolho.hexagonal.application.ports.out.FindCustomerOutputPort

class FindCustomerUseCase(
    private val outputPort: FindCustomerOutputPort
) : FindCustomerInputPort {
    /*
       ?: Elvis operator - Se o valor da esquerda for nulo, o valor da direita será retornado
    */
    override
    fun find(id: String) = outputPort.find(id) ?: throw ObjectNotFoundException("Customer not found")

    override fun findAll(): List<Customer> {
        return outputPort.findAll()
    }

}
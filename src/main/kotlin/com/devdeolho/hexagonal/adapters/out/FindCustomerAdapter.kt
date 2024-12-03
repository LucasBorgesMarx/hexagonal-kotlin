package com.devdeolho.hexagonal.adapters.out

import com.devdeolho.hexagonal.adapters.out.repository.CustomerRepository
import com.devdeolho.hexagonal.application.core.domain.Customer
import com.devdeolho.hexagonal.application.ports.out.FindCustomerOutputPort
import org.springframework.stereotype.Component
import kotlin.jvm.optionals.getOrNull

@Component
class FindCustomerAdapter(
    private val customerRepository: CustomerRepository
) : FindCustomerOutputPort {
    override fun find(id: String): Customer? =
        customerRepository.findById(id)
            .getOrNull()
            .let {
                return it?.toCustomer()
            }

    override fun findAll(): List<Customer> = customerRepository.findAll().map {
        it.toCustomer()
    }

}
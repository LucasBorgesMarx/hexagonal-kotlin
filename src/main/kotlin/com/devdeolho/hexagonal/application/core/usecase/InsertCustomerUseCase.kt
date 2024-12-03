package com.devdeolho.hexagonal.application.core.usecase

import com.devdeolho.hexagonal.application.core.domain.Customer
import com.devdeolho.hexagonal.application.ports.`in`.InsertCustomerInputPort
import com.devdeolho.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort
import com.devdeolho.hexagonal.application.ports.out.InsertCustomerOutputPort
import com.devdeolho.hexagonal.application.ports.out.SendCpfForValidationOutputPort

class InsertCustomerUseCase(
    private val findAddressByZipCodeOutputPort: FindAddressByZipCodeOutputPort,
    private val insertCustomerOutputPort: InsertCustomerOutputPort,
    private val sendCpfForValidationOutputPort: SendCpfForValidationOutputPort
) : InsertCustomerInputPort {
    /*
        Unit == Void Java
        Quando não colocamos o tipo de retorno, o Kotlin entende que é Unit
        When we don't enter the return type, Kotlin understands that it is Unit
        fun e uma função em Kotlin
        fun and a function in Kotlin
    */
    override fun insert(customer: Customer, zipCode: String): Unit {/*
                apply executa um bloco de código e retorna um objeto
                apply executes a block of code and returns an object
                let serve para encadear mais operações nesse resultado do apply
                let us used to handle more operations in the apply result
        */
        customer.apply {
            address = findAddressByZipCodeOutputPort.find(zipCode)
        }.let {
            insertCustomerOutputPort.insert(it)
            sendCpfForValidationOutputPort.send(it.cpf)
        }
    }
}
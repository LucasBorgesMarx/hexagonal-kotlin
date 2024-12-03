package com.devdeolho.hexagonal.application.ports.out

interface DeleteCustomerByIdOutputPort {
    fun delete(id: String)
}
package com.devdeolho.hexagonal.application.core.usecase

import com.devdeolho.hexagonal.application.ports.`in`.DeleteCustomerByIdInputPort
import com.devdeolho.hexagonal.application.ports.`in`.FindCustomerInputPort
import com.devdeolho.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort

class DeleteCustomerByIdUseCase(
    private val findCustomerInputPort: FindCustomerInputPort,
    private val deleteCustomerByIdOutputPort: DeleteCustomerByIdOutputPort
) : DeleteCustomerByIdInputPort {
    override fun delete(id: String) {
        findCustomerInputPort.find(id)
        deleteCustomerByIdOutputPort.delete(id)
    }
}